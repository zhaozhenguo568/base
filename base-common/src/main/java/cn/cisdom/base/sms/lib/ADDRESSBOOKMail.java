package cn.cisdom.base.sms.lib;

import cn.cisdom.base.sms.config.AppConfig;
import cn.cisdom.base.sms.lib.base.ISender;
import cn.cisdom.base.sms.lib.base.SenderWapper;

/**
 * A SenderWapper class as decoration class for user to subscribe and unsubscribe by mail.
 * User can set the basic information of request by included several methods.
 * Then,send the request data by a mode of mail.
 * 
 * @see Mail
 * 
 * @version 1.0 at 2014/10/28
 * */
public class ADDRESSBOOKMail extends SenderWapper {

	/**
	 * If the mode is mail,it's an instance of {@link cn.cisdom.base.sms.config.MailConfig}. If the mode
	 * is message,it's an instance of {@link cn.cisdom.base.sms.config.MessageConfig}
	 * */
	protected AppConfig config = null;
	public static final String ADDRESS = "address";
	public static final String TARGET = "target";

	public ADDRESSBOOKMail(AppConfig config) {
		this.config = config;
	}
	
	public void setAddress(String address, String name){
		requestData.put(ADDRESS, name + "<" + address + ">");
	}
	
	public void setAddressbook(String target){
		requestData.put(TARGET, target);
	}
	@Override
	public ISender getSender() {
		return new Mail(this.config);
	}
	
	public void subscribe(){
		getSender().subscribe(requestData);
	}
	
	public void unsubscribe(){
		getSender().unsubscribe(requestData);
	}
}
