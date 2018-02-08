package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户模板表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-08 16:41:48
 */
public class ModelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户ID
	private String userId;
	//模板ID
	private Integer modelId;
	//模板标题
	private String title;
	//自动分配的域名
	private String allotDomain;
	//用户绑定的域名
	private String bindDomain;
	//ICP备案号
	private String icpNum;
	//公安备案号
	private String policeNum;
	//开通日期
	private Date startTime;
	//到期日期
	private Date expireTime;
	//状态（0 正常 -1 已关闭 1 已过期）
	private Integer status;

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
	 * 设置：模板ID
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	/**
	 * 获取：模板ID
	 */
	public Integer getModelId() {
		return modelId;
	}
	/**
	 * 设置：模板标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：模板标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：自动分配的域名
	 */
	public void setAllotDomain(String allotDomain) {
		this.allotDomain = allotDomain;
	}
	/**
	 * 获取：自动分配的域名
	 */
	public String getAllotDomain() {
		return allotDomain;
	}
	/**
	 * 设置：用户绑定的域名
	 */
	public void setBindDomain(String bindDomain) {
		this.bindDomain = bindDomain;
	}
	/**
	 * 获取：用户绑定的域名
	 */
	public String getBindDomain() {
		return bindDomain;
	}
	/**
	 * 设置：ICP备案号
	 */
	public void setIcpNum(String icpNum) {
		this.icpNum = icpNum;
	}
	/**
	 * 获取：ICP备案号
	 */
	public String getIcpNum() {
		return icpNum;
	}
	/**
	 * 设置：公安备案号
	 */
	public void setPoliceNum(String policeNum) {
		this.policeNum = policeNum;
	}
	/**
	 * 获取：公安备案号
	 */
	public String getPoliceNum() {
		return policeNum;
	}
	/**
	 * 设置：开通日期
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开通日期
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：到期日期
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	/**
	 * 获取：到期日期
	 */
	public Date getExpireTime() {
		return expireTime;
	}
	/**
	 * 设置：状态（0 正常 -1 已关闭 1 已过期）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0 正常 -1 已关闭 1 已过期）
	 */
	public Integer getStatus() {
		return status;
	}
}
