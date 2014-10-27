package com.lim.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.lim.dao.TreeDao;
import com.lim.entity.TSM_FUNCTION;

	public class EasyTongBuShu extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				this.doPost(request, response);
		
		}
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String text=request.getParameter("text");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+text);
			List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
			List<TSM_FUNCTION> list = new ArrayList<TSM_FUNCTION>();// 总结果集合
			List<TSM_FUNCTION> rootList = new ArrayList<TSM_FUNCTION>();// 根集合
			List<TSM_FUNCTION> delList = new ArrayList<TSM_FUNCTION>();// 要删除的list集合
			
			TreeDao dao = new TreeDao();
			list = dao.findByText(text);
			if(list.size()!=0)//查询结果不为空
			{
				//查找所有的根节点
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFldparentid()==null){
					rootList.add(list.get(i));
					delList.add(list.get(i));
				}
			}
			//从list中移除根节点
			for(TSM_FUNCTION obj:delList){
				list.remove(obj);
			}
			//得到树对象
			for (int i = 0; i < rootList.size(); i++) {
				List<TSM_FUNCTION> sonList = new ArrayList<TSM_FUNCTION>();// 子集合
				Map<String, Object> tree = new HashMap<String, Object>();
				for(TSM_FUNCTION obj:list){
					if(obj.getFldparentid().equals(rootList.get(i).getFldid())){
						sonList.add(obj);
					}
				}
				tree.put("id", rootList.get(i).getFldid());
				tree.put("text", rootList.get(i).getFldsfuncname());
				tree.put("attributes",  rootList.get(i).getFldparentid());
				if (!sonList.isEmpty()) {// 判断是否是叶子节点
					 tree.put("state", "closed");
					tree.put("children", this.getChildren(list,sonList));
				}
				retList.add(tree);
			}

			JSONArray json=JSONArray.fromObject(retList);
			response.getWriter().write(json.toString());
			}else{
				response.getWriter().write("{\"length\":\"0\"}");
			}
	}

	public List<Map<String, Object>>  getChildren(List<TSM_FUNCTION> allList,List<TSM_FUNCTION> list) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		List<TSM_FUNCTION> sonList = new ArrayList<TSM_FUNCTION>();// 子集合
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> tree = new HashMap<String, Object>();//重复树 在这里出问题了  ！！！！！！！！！！！！
				tree.put("id", list.get(i).getFldid());
				tree.put("text", list.get(i).getFldsfuncname());
				tree.put("attributes",  list.get(i).getFldparentid());
				sonList=this.getSonList(allList,  list.get(i).getFldid());
			if (!sonList.isEmpty()) {
			 	tree.put("state", "closed");
				tree.put("children", this.getChildren(allList,sonList));
			}
			retList.add(tree);
		}
			return retList;
	}

	public 	List<TSM_FUNCTION> getSonList(List<TSM_FUNCTION> list,String id){
		List<TSM_FUNCTION> sonList = new ArrayList<TSM_FUNCTION>();// 子集合
		for(TSM_FUNCTION obj:list){
			if(obj.getFldparentid().equals(id)){
				sonList.add(obj);
			}
		}
		return sonList;
		
	};
	}
