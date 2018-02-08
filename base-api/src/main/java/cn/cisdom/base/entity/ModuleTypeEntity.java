package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 栏目类型表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-15 13:36:57
 */
public class ModuleTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//模板ID
	private Integer umId;
	//栏目ID
	private Integer moduleId;
	//分类名称
	private String title;
	//排序值
	private Integer sort;
	//创建时间
	private Date createTime;

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
	 * 设置：模板ID
	 */
	public void setUmId(Integer umId) {
		this.umId = umId;
	}
	/**
	 * 获取：模板ID
	 */
	public Integer getUmId() {
		return umId;
	}
	/**
	 * 设置：栏目ID
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * 获取：栏目ID
	 */
	public Integer getModuleId() {
		return moduleId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：分类名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：排序值
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序值
	 */
	public Integer getSort() {
		return sort;
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
}
