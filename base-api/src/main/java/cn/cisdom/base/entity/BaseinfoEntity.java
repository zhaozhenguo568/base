package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 网站基础信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-18 15:05:07
 */
public class BaseinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户模板ID
	private Integer umId;
	//网站名称
	private String title;
	//LOGO图片路径
	private String logoPic;
	//联系方式（如有多个 , 隔开）
	private String contactPhone;
	//联系邮箱
	private String email;
	//地址
	private String address;
	//二维码
	private String qrcode;
	//经度
	private String longitude;
	//纬度
	private String latitude;

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
	 * 设置：用户模板ID
	 */
	public void setUmId(Integer umId) {
		this.umId = umId;
	}
	/**
	 * 获取：用户模板ID
	 */
	public Integer getUmId() {
		return umId;
	}
	/**
	 * 设置：网站名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：网站名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：LOGO图片路径
	 */
	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}
	/**
	 * 获取：LOGO图片路径
	 */
	public String getLogoPic() {
		return logoPic;
	}
	/**
	 * 设置：联系方式（如有多个 , 隔开）
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系方式（如有多个 , 隔开）
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：联系邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：联系邮箱
	 */
	public String getEmail() {
		return email;
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
	 * 设置：二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 获取：二维码
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
}
