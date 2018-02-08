package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户基础信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//用户名
	private String userName;
	//用户昵称
	private String nickname;
	//手机号
	private String mobile;
	//密码
	private transient String password;
	//邮箱
	private String email;
	//QQ
	private String qq;
	//地址
	private String address;
	//微信账号
	private String wxAccount;
	//创建时间
	private Date createTime;
	//最后一次登录时间
	private Date lastLoginTime;
	//用户状态（0 冻结 1 正常）
	private Integer status;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：用户昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：微信账号
	 */
	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}
	/**
	 * 获取：微信账号
	 */
	public String getWxAccount() {
		return wxAccount;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后一次登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * 获取：最后一次登录时间
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * 设置：用户状态（0 冻结 1 正常）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：用户状态（0 冻结 1 正常）
	 */
	public Integer getStatus() {
		return status;
	}
}
