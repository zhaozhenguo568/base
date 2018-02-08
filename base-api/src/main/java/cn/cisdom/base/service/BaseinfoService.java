package cn.cisdom.base.service;

import cn.cisdom.base.entity.BaseinfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 网站基础信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-18 15:05:07
 */
public interface BaseinfoService {
	
	BaseinfoEntity queryObject(Integer id);
	
	List<BaseinfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseinfoEntity baseinfo);
	
	void update(BaseinfoEntity baseinfo);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
