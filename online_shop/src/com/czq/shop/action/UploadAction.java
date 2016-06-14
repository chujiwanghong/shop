package com.czq.shop.action;

import com.czq.shop.BaseAction;
import com.czq.shop.model.EvaluateModel;
import com.czq.shop.model.ProductModel;
import com.czq.shop.service.ProductService;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Random;  

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;  
public class UploadAction extends BaseAction {
    //封装多个上传文件域的属性  
    private List<File> upload = new ArrayList<File>();  
    // 封装多个上传文件类型的属性  
    private List<String> uploadContentType = new ArrayList<String>();  
    // 封装多个上传文件名的属性  
    private List<String> uploadFileName = new ArrayList<String>(); 
    // 封装多个上传文件的描述  
    private List<String> note = new ArrayList<String>();    
    //动态设置上传文件保存地址  
    private String savePath;  
    private long productId;				//产品ID
	private String productName;			//产品名称
	private String merchantName;		//商家名称
	private String productType;			//所属类目
	private double productPrice;		//产品价格
	private double discountPrice;		//促销价格
	private String indexPictuer;		//主页图片URL
	private int inventoryNum;			//库存数量
	private String simpleDescribe;		//简单描述
	private List<EvaluateModel> evaluate;		//产品描述
	private EvaluateModel  evaluateModel;		//描述Model
    private ProductModel productModel;			//商品Model
    private ProductService productService;						//商品Service
    
    //生成商品ID
    public int creatProductId(){
    	int temproductId=productService.findBigProductId();
    	return temproductId+1;
    }
    
    
    public String upload() {  
        //上传多个文件  
        List<File> files = getUpload();  
        // String ext ="";  
        FileOutputStream fos = null;  
        FileOutputStream fosF = null;  
        FileInputStream fis = null;  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        Random rd = new Random();
        setProductId(creatProductId());     //获取商品ID
        for (int i = 0; i < files.size(); i++) {  
            try {  
                //以服务器的文件保存地址和当前时间组合文件名建立上传文件输出流  
                // ext =uploadFileName.get(i).substring(uploadFileName.get(i).lastIndexOf('.'));  
                 /* fos = new FileOutputStream(getSavePath()+ File.separator+ 
                 * DateFormatUtil.getCurrentCustomFormatDateTime(DateFormatUtil.DATE_TIME_FORMAT_14) + 
                 * String.valueOf(rd.nextInt(1000))+ext); 
                 */ 
            	String name=String.valueOf(productId)+"i"+String.valueOf(i)+".jpg";
            	uploadFileName.set(i, name);
            	if(i==0){
            		fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/image/home") + File.separator  + uploadFileName.get(i)); 
            		fosF = new FileOutputStream("E:/image/home" + File.separator  + uploadFileName.get(i));
            	}
            	else{
            		fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/image/product") + File.separator  + uploadFileName.get(i));
            		fosF = new FileOutputStream( "E:/image/product"+ File.separator  + uploadFileName.get(i)); 
            	}
            	// 以上传文件建立一个文件上传流  
                fis = new FileInputStream(files.get(i));  
                // 将上传文件的内容写入服务器  
                len = 0;  
                while ((len = fis.read(buffer)) > 0) {  
                    fos.write(buffer, 0, len);
                    fosF.write(buffer, 0, len);
                    
                } 
                fosF.close();
                fos.close();
                fis.close();
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
          
        for(int i=0;i<uploadFileName.size();i++)
        {
        	if(i==0){
        		if(productModel==null){
        			productModel=new ProductModel();
        		}
        		indexPictuer="image/home/"  + uploadFileName.get(i);
        		productModel.setDiscountPrice(discountPrice);
        		productModel.setIndexPictuer(indexPictuer);
        		productModel.setInventoryNum(inventoryNum);
        		productModel.setMerchantName(merchantName);
        		productModel.setProductId(productId);
        		productModel.setProductName(productName);
        		productModel.setProductPrice(productPrice);
        		productModel.setProductType(productType);
        		productModel.setSaleNum(0);
        		productModel.setSimpleDescribe(simpleDescribe);
        		productService.insertProduct(productModel);
        	}
        	else{
        		if(evaluateModel==null){
        			evaluateModel=new EvaluateModel();
        			}
        		evaluateModel.setDescribeCharacter(note.get(i));
        		evaluateModel.setDescribeId(i);
        		evaluateModel.setDescribePicture("image/product/"  + uploadFileName.get(i));
        		evaluateModel.setDescribeType(1);
        		evaluateModel.setProductId(productId);
        		evaluateModel.setMerchantName(merchantName);
        		evaluateModel.setDescribeUser(merchantName);
        		productService.insertEvaluate(evaluateModel);	
        	} 
        }
        return SUCCESS;
        
    }

    
    
    
    
    public String getSavePath() {  
        return savePath;  
    }  
  
    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  
	/**
	 * @return the upload
	 */
	public List<File> getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the uploadFileName
	 */
	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the note
	 */
	public List<String> getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(List<String> note) {
		this.note = note;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the discountPrice
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * @return the indexPictuer
	 */
	public String getIndexPictuer() {
		return indexPictuer;
	}

	/**
	 * @param indexPictuer the indexPictuer to set
	 */
	public void setIndexPictuer(String indexPictuer) {
		this.indexPictuer = indexPictuer;
	}

	/**
	 * @return the inventoryNum
	 */
	public int getInventoryNum() {
		return inventoryNum;
	}

	/**
	 * @param inventoryNum the inventoryNum to set
	 */
	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	/**
	 * @return the simpleDescribe
	 */
	public String getSimpleDescribe() {
		return simpleDescribe;
	}

	/**
	 * @param simpleDescribe the simpleDescribe to set
	 */
	public void setSimpleDescribe(String simpleDescribe) {
		this.simpleDescribe = simpleDescribe;
	}

	/**
	 * @return the evaluate
	 */
	public List<EvaluateModel> getEvaluate() {
		return evaluate;
	}

	/**
	 * @param evaluate the evaluate to set
	 */
	public void setEvaluate(List<EvaluateModel> evaluate) {
		this.evaluate = evaluate;
	}

	/**
	 * @return the evaluateModel
	 */
	public EvaluateModel getEvaluateModel() {
		return evaluateModel;
	}

	/**
	 * @param evaluateModel the evaluateModel to set
	 */
	public void setEvaluateModel(EvaluateModel evaluateModel) {
		this.evaluateModel = evaluateModel;
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

} 
