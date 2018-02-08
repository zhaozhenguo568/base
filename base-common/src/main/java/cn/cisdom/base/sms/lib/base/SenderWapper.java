package cn.cisdom.base.sms.lib.base;


import cn.cisdom.base.sms.entity.DataStore;

public abstract class SenderWapper {

	protected DataStore requestData = new DataStore();

	public abstract ISender getSender();
}
