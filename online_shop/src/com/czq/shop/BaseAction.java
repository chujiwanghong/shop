package com.czq.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import com.opensymphony.xwork2.Action;

/**
 * Action的baseAction
 * 
 * @author
 * 
 */
public abstract class BaseAction implements Action,
		MessageSourceAware {

	public static final String UTF8 = "UTF-8";
	public static final String PASSWORD_RESET = "passwordReset";
	public static final String LOG_OUT = "logout";
	public final String SYSTEM_NAME="网上超市";
	protected String backUrl;// 跳转目标url
	private MessageSource messageSource;
	private int page;//第几页
	private int rows;//行数
	protected String errorMessage;//异常信息
	private final Log log = LogFactory.getLog(BaseAction.class);
	
	private static Long JS_VERSION = (new Date()).getTime();
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void ajaxPrintPage(Object obj) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding(UTF8);
		PrintWriter writer = null;
		try {
			try {
				writer = response.getWriter();
				if(null==obj){
					writer.print("");
				}else{
					writer.print(obj.toString());
				}	
			} catch (IOException e) {
				log.error("BaseAction ajaxPrintPage IOException", e);
			}
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	public String decode(String encodeStr) {
		if(StringUtils.isBlank(encodeStr)) {
			return null;
		}
		try {
			encodeStr = URLDecoder.decode(encodeStr, UTF8);
		} catch (UnsupportedEncodingException e) {
			log.error("BaseAction decode UnsupportedEncodingException", e);
		}
		return encodeStr;
	}

	public String redirectBackUrl() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding(UTF8);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.sendRedirect(backUrl);
		} catch (IOException e) {
			log.error("BaseAction redirectBackUrl IOException", e);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception {
        return SUCCESS;
    }

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    public  Long getJS_VERSION() {
        return JS_VERSION;
    }
}
