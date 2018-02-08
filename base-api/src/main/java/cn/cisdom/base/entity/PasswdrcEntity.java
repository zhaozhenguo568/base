package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户登录密码设置记录表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public class PasswdrcEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户ID
	private String userId;
	//密码
	private String passwd;
	//设置时间
	private Date setTime;

	/**
	 * 设置：主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：密码
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * 获取：密码
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * 设置：设置时间
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	/**
	 * 获取：设置时间
	 */
	public Date getSetTime() {
		return setTime;
	}
}
