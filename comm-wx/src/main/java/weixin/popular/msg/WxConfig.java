package weixin.popular.msg;

import java.io.Serializable;

/**
 * JS微信接口配置信息
 * @author Administrator
 *
 */
public class WxConfig implements Serializable {
	private String appId;
	private Long timestamp;
	private String nonceStr;
	private String signature;
	
	public WxConfig() {
		super();
	}
	public WxConfig(String appId) {
		super();
		this.appId = appId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
	
}
