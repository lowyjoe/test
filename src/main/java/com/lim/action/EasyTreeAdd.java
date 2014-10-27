package com.lim.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;

import com.lim.base.ActionBase;
import com.lim.dao.TreeDao;
import com.lim.entity.TSM_FUNCTION;

public class EasyTreeAdd extends ActionBase {
	private String pid;
	private String text;
	private TreeDao dao;
	public TreeDao getDao() {
		return dao;
	}

	public void setDao(TreeDao dao) {
		this.dao = dao;
	}
	public void EasyTreeAdd() throws Exception{
		String sParentId = pid;
		if (sParentId.equals("null")||sParentId.equals("undefined")) {
			sParentId = "";
		}
		TSM_FUNCTION fun = new TSM_FUNCTION();
		String s = UUID.randomUUID().toString();
		// 去掉"-"符号
		String fldid = s.substring(0, 8) + s.substring(9, 13)
				+ s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		System.out.println(">>>>>>>>>" + fldid + "添加兄弟菜单");
		fun.setFldid(fldid);
		fun.setFldparentid(sParentId);
		fun.setFldsfuncname(text);
		try {
			dao.addBrother(fun);
		} catch (Exception e) {
			write(
					"{\"success\":false,\"msg\":\"添加兄弟菜单失败\"}",this.CONTENTTYPE_JSON);
			e.printStackTrace();
		}
		write(
				"{\"success\":true,\"msg\":\"添加兄弟菜单成功\",\"id\":\"" + fldid
						+ "\",\"text\":\"" + text + "\"}",this.CONTENTTYPE_JSON);

	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	};

 
}
