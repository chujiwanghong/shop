package com.czq.shop.action;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.czq.shop.BaseAction;
import com.czq.shop.model.OderProductModel;
import com.czq.shop.model.OrderFormModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.model.ProductSearchModel;
import com.czq.shop.service.OrderService;
import com.czq.shop.service.ProductService;
import com.czq.shop.service.UserService;



public class OrderAction extends BaseAction {
	private OrderService orderService;							//订单Service
	private ProductService productService;						//商品Service
	private UserService userService;							//用户Service
	private ProductModel productModel;							//商品Model
	private Object result;										//ajax返回json数据
	private List<OrderFormModel> orderFormList;					//订单list
	private OrderFormModel orderFormModel;						//商品Model
	private List<ProductModel> productlist;
	private List<OderProductModel> oderProductList;				//商品list
	private OderProductModel oderProductModel;
	private ProductSearchModel  productSearch;					//搜索条件Model
	private String orderId;										//订单ID
	private String merchant;									//商家名
	private String userName;									//用户名
	private Date orderTime;			//下单时间
	private Date deliverTime;		//发货时间
	private Date receiptTime;		//收货时间
	private String address;			//收货地址
	private String xpressCompany;	//快递公司
	private long xpressNumber;		//快递单号
	private double totalPrice;		//订单总价
	private String number;			//购买数量
	private String transactionPrice; //成交价
	private String productId; 		//产品编号
	
	OrderAction(){
		if(productSearch==null){
			productSearch=new ProductSearchModel();
		}
		if(orderFormModel==null){
			orderFormModel=new OrderFormModel();
		}
		if(oderProductModel==null){
			oderProductModel=new OderProductModel();
		}
		if(productModel==null){
			productModel=new ProductModel();
		}
	}
	
 
	public String orderjsonQueryForm(){
		if(orderId!=null){
			productSearch.setProductId(Integer.parseInt(orderId));
		}
		if(userName!=null){
			productSearch.setUserName(userName);
		}
		if(merchant!=null&&!("chenzhiqiang".equals(merchant))){
			productSearch.setMerchant(merchant);;
		}
		else{
			productSearch.setMerchant("");
		}
		orderFormList=orderService.queryOrderFormById(productSearch);
		JSONArray array = JSONArray.fromObject(orderFormList);
		result=array;
		return SUCCESS;
	}
	
	public String orderjsonQueryProduct(){
		if(orderId!=null){
			productSearch.setProductId(Integer.parseInt(orderId));
		}
		oderProductList=orderService.queryOderProductById(productSearch);
		JSONArray array = JSONArray.fromObject(oderProductList);
		result=array;
		return SUCCESS;
	}
	
	public String orderjsonInsertForm(){
		if(transactionPrice.startsWith("促销价")){
			transactionPrice=transactionPrice.substring(3);
		}
		totalPrice=Double.valueOf(transactionPrice)*Integer.parseInt(number);
		orderFormModel.setOrderId(orderService.findOrderFormId());
		orderFormModel.setMerchant(merchant);
		address=userService.queryByUserName(userName).get(0).getUserAddress();
		orderFormModel.setAddress(address);
		orderFormModel.setUserName(userName);
		orderFormModel.setTotalPrice(totalPrice);
		orderService.insertOrderForm(orderFormModel);
		oderProductModel.setOrderId(orderFormModel.getOrderId());
		oderProductModel.setNumber(Integer.parseInt(number));
		oderProductModel.setProductId(Integer.parseInt(productId));
		oderProductModel.setTransactionPrice(Double.valueOf(transactionPrice));
		orderService.insertOderProduct(oderProductModel);
		
		productSearch.setProductId(Integer.parseInt(productId));
		productlist=productService.queryProductById(productSearch);
		productModel=productlist.get(0);
		productModel.setProductId(Integer.parseInt(productId));
		productModel.setSaleNum(productModel.getSaleNum()+Integer.parseInt(number));
		productModel.setInventoryNum(productModel.getInventoryNum()-Integer.parseInt(number));
		productService.updateSaleById(productModel);
		result=null;
		return SUCCESS;
	}
	
	public String orderjsonUpdateDeliver(){
		orderFormModel.setOrderId(Integer.parseInt(orderId));
		orderFormModel.setXpressCompany(xpressCompany);
		orderFormModel.setXpressNumber(xpressNumber);
		orderService.updateDeliverTimeById(orderFormModel);
		result=null;
		return SUCCESS;
	}
	
	public String orderjsonUpdateReceipt(){
		orderFormModel.setOrderId(Integer.parseInt(orderId));
		orderService.updateReceiptTimeById(orderFormModel);
		result=null;
		return SUCCESS;
	}
	
	public String orderjsonUpdatePay(){
		orderFormModel.setOrderId(Integer.parseInt(orderId));
		orderService.updatePayTimeById(orderFormModel);
		result=null;
		return SUCCESS;
	}
	
	public String orderjsonUpdateGet(){
		orderFormModel.setOrderId(Integer.parseInt(orderId));
		orderService.updateGetTimeById(orderFormModel);
		result=null;
		return SUCCESS;
	}
	

	/**
	 * @return orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService 要设置的 orderService
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * @return result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result 要设置的 result
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return orderFormList
	 */
	public List<OrderFormModel> getOrderFormList() {
		return orderFormList;
	}

	/**
	 * @param orderFormList 要设置的 orderFormList
	 */
	public void setOrderFormList(List<OrderFormModel> orderFormList) {
		this.orderFormList = orderFormList;
	}

	/**
	 * @return orderFormModel
	 */
	public OrderFormModel getOrderFormModel() {
		return orderFormModel;
	}

	/**
	 * @param orderFormModel 要设置的 orderFormModel
	 */
	public void setOrderFormModel(OrderFormModel orderFormModel) {
		this.orderFormModel = orderFormModel;
	}

	/**
	 * @return oderProductList
	 */
	public List<OderProductModel> getOderProductList() {
		return oderProductList;
	}

	/**
	 * @param oderProductList 要设置的 oderProductList
	 */
	public void setOderProductList(List<OderProductModel> oderProductList) {
		this.oderProductList = oderProductList;
	}

	/**
	 * @return productSearch
	 */
	public ProductSearchModel getProductSearch() {
		return productSearch;
	}

	/**
	 * @param productSearch 要设置的 productSearch
	 */
	public void setProductSearch(ProductSearchModel productSearch) {
		this.productSearch = productSearch;
	}


	/**
	 * @return orderId
	 */
	public String getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId 要设置的 orderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	/**
	 * @return merchant
	 */
	public String getMerchant() {
		return merchant;
	}


	/**
	 * @param merchant 要设置的 merchant
	 */
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}


	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}


	/**
	 * @param orderTime 要设置的 orderTime
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	/**
	 * @return deliverTime
	 */
	public Date getDeliverTime() {
		return deliverTime;
	}


	/**
	 * @param deliverTime 要设置的 deliverTime
	 */
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}


	/**
	 * @return receiptTime
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}


	/**
	 * @param receiptTime 要设置的 receiptTime
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}


	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return xpressCompany
	 */
	public String getXpressCompany() {
		return xpressCompany;
	}


	/**
	 * @param xpressCompany 要设置的 xpressCompany
	 */
	public void setXpressCompany(String xpressCompany) {
		this.xpressCompany = xpressCompany;
	}


	/**
	 * @return xpressNumber
	 */
	public long getXpressNumber() {
		return xpressNumber;
	}


	/**
	 * @param xpressNumber 要设置的 xpressNumber
	 */
	public void setXpressNumber(long xpressNumber) {
		this.xpressNumber = xpressNumber;
	}


	/**
	 * @return totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}


	/**
	 * @param totalPrice 要设置的 totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * @return oderProductModel
	 */
	public OderProductModel getOderProductModel() {
		return oderProductModel;
	}


	/**
	 * @param oderProductModel 要设置的 oderProductModel
	 */
	public void setOderProductModel(OderProductModel oderProductModel) {
		this.oderProductModel = oderProductModel;
	}


	/**
	 * @return userService
	 */
	public UserService getUserService() {
		return userService;
	}


	/**
	 * @param userService 要设置的 userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}


	/**
	 * @param number 要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}


	/**
	 * @return transactionPrice
	 */
	public String getTransactionPrice() {
		return transactionPrice;
	}


	/**
	 * @param transactionPrice 要设置的 transactionPrice
	 */
	public void setTransactionPrice(String transactionPrice) {
		this.transactionPrice = transactionPrice;
	}


	/**
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}


	/**
	 * @param productId 要设置的 productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}


	/**
	 * @return productService
	 */
	public ProductService getProductService() {
		return productService;
	}


	/**
	 * @param productService 要设置的 productService
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	/**
	 * @return productModel
	 */
	public ProductModel getProductModel() {
		return productModel;
	}


	/**
	 * @param productModel 要设置的 productModel
	 */
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}


	/**
	 * @return productlist
	 */
	public List<ProductModel> getProductlist() {
		return productlist;
	}


	/**
	 * @param productlist 要设置的 productlist
	 */
	public void setProductlist(List<ProductModel> productlist) {
		this.productlist = productlist;
	}
	

}
