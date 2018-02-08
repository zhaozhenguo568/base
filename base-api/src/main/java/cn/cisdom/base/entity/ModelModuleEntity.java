package cn.cisdom.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 模板模块信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-15 11:10:27
 */
public class ModelModuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户模板ID
	private Integer umId;
	//模块名称
	private String title;
	//副标题
	private String subtitle;
	//模块类型（0 系统栏目 1 列表展示 3 单页）
	private String type;
	//父级ID
	private Integer parentId;
	//级别 （1 一级栏目 2 二级栏目）
	private String level;
	//栏目主图（手机）
	private String mPic;
	//栏目主图
	private String pcPic;
	//排序值
	private Integer sort;
	//是否分类（ 0 是 1 否）
	private String isClass;
	//是否在菜单中显示（0 是 1 否）
	private String isShow;
	//是否首页展示（0是 1 否）
	private String indexShow;
	//打开方式（0 当前页 1 新标签页）
	private String openType;
	//创建时间
	private Date createDate;

	private String typeName;

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
	 * 设置：模块名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：模块名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：副标题
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	/**
	 * 获取：副标题
	 */
	public String getSubtitle() {
		return subtitle;
	}
	/**
	 * 设置：模块类型（0 系统栏目 1 列表展示 3 单页）
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：模块类型（0 系统栏目 1 列表展示 3 单页）
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：父级ID
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级ID
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：级别 （1 一级栏目 2 二级栏目）
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：级别 （1 一级栏目 2 二级栏目）
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：栏目主图（手机）
	 */
	public void setMPic(String mPic) {
		this.mPic = mPic;
	}
	/**
	 * 获取：栏目主图（手机）
	 */
	public String getMPic() {
		return mPic;
	}
	/**
	 * 设置：栏目主图
	 */
	public void setPcPic(String pcPic) {
		this.pcPic = pcPic;
	}
	/**
	 * 获取：栏目主图
	 */
	public String getPcPic() {
		return pcPic;
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
	 * 设置：是否分类（ 0 是 1 否）
	 */
	public void setIsClass(String isClass) {
		this.isClass = isClass;
	}
	/**
	 * 获取：是否分类（ 0 是 1 否）
	 */
	public String getIsClass() {
		return isClass;
	}
	/**
	 * 设置：是否在菜单中显示（0 是 1 否）
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否在菜单中显示（0 是 1 否）
	 */
	public String getIsShow() {
		return isShow;
	}
	/**
	 * 设置：是否首页展示（0是 1 否）
	 */
	public void setIndexShow(String indexShow) {
		this.indexShow = indexShow;
	}
	/**
	 * 获取：是否首页展示（0是 1 否）
	 */
	public String getIndexShow() {
		return indexShow;
	}
	/**
	 * 设置：打开方式（0 当前页 1 新标签页）
	 */
	public void setOpenType(String openType) {
		this.openType = openType;
	}
	/**
	 * 获取：打开方式（0 当前页 1 新标签页）
	 */
	public String getOpenType() {
		return openType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
