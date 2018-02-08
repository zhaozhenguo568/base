package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 图形验证码
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-07 15:58:37
 */
public class CaptchaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//验证码
	private String captcha;
	//生成时间
	private Date createTime;

	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：验证码
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	/**
	 * 获取：验证码
	 */
	public String getCaptcha() {
		return captcha;
	}
	/**
	 * 设置：生成时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：生成时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
