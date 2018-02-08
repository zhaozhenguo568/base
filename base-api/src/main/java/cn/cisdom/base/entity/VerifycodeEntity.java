package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 验证码发送记录表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:04
 */
public class VerifycodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户手机号
	private String mobile;
	//除注册外需插入该字段
	private String userId;
	//1 注册 2 找回密码 3 修改手机号
	private String type;
	//状态（0 不可用 1 可用）
	private String status;
	//发送时间
	private Date sendTime;
	//过期时间
	private Date expireTime;
	//验证码
	private String code;
	//IP
	private String ip;

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
	 * 设置：用户手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：用户手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：除注册外需插入该字段
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：除注册外需插入该字段
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：1 注册 2 找回密码 3 修改手机号
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1 注册 2 找回密码 3 修改手机号
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：状态（0 不可用 1 可用）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0 不可用 1 可用）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：过期时间
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：过期时间
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
