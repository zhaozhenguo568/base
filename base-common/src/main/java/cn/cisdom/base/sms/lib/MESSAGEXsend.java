package cn.cisdom.base.sms.lib;

import cn.cisdom.base.sms.config.AppConfig;
import cn.cisdom.base.sms.lib.base.ISender;
import cn.cisdom.base.sms.lib.base.SenderWapper;

/**
 * A SenderWapper class as decoration class for user to send request by message.
 * User can set the basic information of request by included several methods.
 * Then,send the request data by a mode of message.By this pattern,user needn't
 * offer the message content and message signature,change the message content by variable dynamicly if prividing only id which
 * created in submail application.
 * 
 * 
 * @version 1.0 at 2014/10/28
 * */
public class MESSAGEXsend extends SenderWapper {

	/**
	 * If the mode is mail,it's an instance of {@link cn.cisdom.base.sms.config.MailConfig}. If the mode
	 * is message,it's an instance of {@link cn.cisdom.base.sms.config.MessageConfig}
	 * */
	protected AppConfig config = null;
	public static final String ADDRESSBOOK = "addressbook";
	public static final String TO = "to";
	public static final String PROJECT = "project";
	public static final String VARS = "vars";
	public static final String LINKS = "links";

	public MESSAGEXsend(AppConfig config) {
		this.config = config;
	}

	public void addTo(String address) {
		requestData.addWithComma(TO, address);
	}

	public void addAddressBook(String addressbook) {
		requestData.addWithComma(ADDRESSBOOK, addressbook);
	}

	public void setProject(String project) {
		requestData.put(PROJECT, project);
	}
	
	public void addVar(String key, String val) {
		requestData.addWithJson(VARS, key, val);
	}
	
	@Override
	public ISender getSender() {
		return new Message(this.config);
	}

	public boolean xsend(){
		return getSender().xsend(requestData);
	}
}
