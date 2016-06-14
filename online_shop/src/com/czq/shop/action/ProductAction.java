package com.czq.shop.action;

import java.util.List;
import net.sf.json.JSONArray;
import com.czq.shop.BaseAction;
import com.czq.shop.model.CategoryModel;
import com.czq.shop.model.EvaluateModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.model.ProductSearchModel;
import com.czq.shop.service.ProductService;



public class ProductAction extends BaseAction {
	private ProductService productService;						//商品Service
	private Object result;										//ajax返回json数据
	private List<ProductModel> productList;						//商品list
	private ProductModel productModel;							//商品Model
	private List<EvaluateModel> evaluateList;					//描述list
	private List<CategoryModel> categoryList;					//类目list
	private ProductSearchModel  productSearch;					//搜索条件Model
	private String productId;									//商品ID
	private String merchantName;								//商家名称
	private String productType;									//产品所属类目
	private String productName;									//产品名称
	
	ProductAction(){
		if(productSearch==null){
			productSearch=new ProductSearchModel();
		}
		if(productModel==null){
			productModel=new ProductModel();
		}
	}
	
	public String productftlAdd(){
		return SUCCESS;
	}
	
	
	public String productftlPage(){
		return SUCCESS;
	}
	
	public String productjsonQuery(){
		if(productId.length()==0){
			productId="0";
		}
		else if(productId.indexOf(",")!=-1){
			productId=productId.substring(0, productId.indexOf(","))+productId.substring(productId.indexOf(",")+1, productId.length());
		}
		productSearch.setProductId(Integer.parseInt(productId));
		if(!("chenzhiqiang".equals(merchantName))){
			productSearch.setUserName(merchantName);
		}
		if(productName!=null){
			productSearch.setProductName(productName);
		}
		productList = productService.queryProductById(productSearch);
		for(int i=0;i<productList.size();i++){
			long temProductId = productList.get(i).getProductId();
			productSearch.setProductId(temProductId);
			evaluateList=productService.queryDescribeByProductId(productSearch);
			productList.get(i).setEvaluate(evaluateList);
		}
		JSONArray array = JSONArray.fromObject(productList);
		//DateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result=array;
		return "success";
	}
	
	public String productjsonDescribe(){
		if(productId.length()==0){
			productId="0";
		}
		productSearch.setProductId(Integer.parseInt(productId));
		evaluateList=productService.queryDescribeByProductId(productSearch);

		JSONArray array = JSONArray.fromObject(evaluateList);
		result=array;
		return "success";
	}
	
	public String productjsonHotProduct(){
		if(productType==null){
			productType="0";
		}
		else if(productType.length()==0){
			productType="0";
		}
		productSearch.setProductId(Integer.parseInt(productType));
		productList = productService.queryHotProductById(productSearch);
		for(int i=0;i<productList.size();i++){
			long temProductId = productList.get(i).getProductId();
			productSearch.setProductId(temProductId);
			evaluateList=productService.queryDescribeByProductId(productSearch);
			productList.get(i).setEvaluate(evaluateList);
		}
		JSONArray array = JSONArray.fromObject(productList);
		result=array;
		return "success";
	}
	
	public String productjsonCategory(){
		if(productType.length()==0){
			productType="0";
		}
		productSearch.setProductId(Integer.parseInt(productType));
		categoryList = productService.queryCategoryById(productSearch);
		JSONArray array = JSONArray.fromObject(categoryList);
		result=array;
		return "success";
	}
	
	
	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}
	/**
	 * @param productService the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	/**
	 * @return the productList
	 */
	public List<ProductModel> getProductList() {
		return productList;
	}
	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}
	/**
	 * @return the productModel
	 */
	public ProductModel getProductModel() {
		return productModel;
	}
	/**
	 * @param productModel the productModel to set
	 */
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	/**
	 * @return the productSearch
	 */
	public ProductSearchModel getProductSearch() {
		return productSearch;
	}

	/**
	 * @param productSearch the productSearch to set
	 */
	public void setProductSearch(ProductSearchModel productSearch) {
		this.productSearch = productSearch;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @return the evaluateList
	 */
	public List<EvaluateModel> getEvaluateList() {
		return evaluateList;
	}

	/**
	 * @param evaluateList the evaluateList to set
	 */
	public void setEvaluateList(List<EvaluateModel> evaluateList) {
		this.evaluateList = evaluateList;
	}

	/**
	 * @return the categoryList
	 */
	public List<CategoryModel> getCategoryList() {
		return categoryList;
	}

	/**
	 * @param categoryList the categoryList to set
	 */
	public void setCategoryList(List<CategoryModel> categoryList) {
		this.categoryList = categoryList;
	}

	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName 要设置的 productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
