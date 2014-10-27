package com.lim.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.lim.base.ActionBase;
import com.lim.dao.TreeDao;
import com.lim.entity.TSM_FUNCTION;
import com.opensymphony.xwork2.util.logging.Logger;

public class EasyTreeQuery extends ActionBase {
	private String id;
	private TreeDao dao;
	public TreeDao getDao() {
		return dao;
	}

	public void setDao(TreeDao dao) {
		this.dao = dao;
	}
	public void EasyTreeQuery() throws Exception{
	List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
	List<TSM_FUNCTION> sonList = new ArrayList<TSM_FUNCTION>();// 子集合
	List<TSM_FUNCTION> rootList = new ArrayList<TSM_FUNCTION>();// 根集合
	System.out.println(id);
	rootList = dao.getRes(id);
	for (int i = 0; i < rootList.size(); i++) {
		Map<String, Object> tree = new HashMap<String, Object>();
		sonList = dao.querySonList(rootList.get(i).getFldid());
		tree.put("id", rootList.get(i).getFldid());
		tree.put("text", rootList.get(i).getFldsfuncname());
		tree.put("attributes", rootList.get(i).getFldparentid());
		if (!sonList.isEmpty()) {// 判断是否是叶子节点
			tree.put("state", "closed");
		}
		retList.add(tree);
	}

	JSONArray json = JSONArray.fromObject(retList);
	System.out.println("?????????????????????" + json.toString());
	response.getWriter().write(json.toString());
	// response.getWriter().write("[{id:'1',text:'yiyi'}]");//easyui对数据有严格的格式要求
	// response.getWriter().print("[{\"id\":\"a\",\"text\":\"江苏省\"},{\"id\":\"b\",\"text\":\"浙江省\"},{\"id\":\"c\",\"text\":\"安徽省\"}]");

}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	};

 
}
