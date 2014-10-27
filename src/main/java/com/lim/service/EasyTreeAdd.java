package com.lim.service;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lim.dao.TreeDao;
import com.lim.entity.TSM_FUNCTION;

/**
 * Servlet implementation class EasyTreeAdd
 */
public class EasyTreeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// String selectId= request.getParameter("selectId");
		String sParentId = request.getParameter("pid");
		if (sParentId.equals("null")||sParentId.equals("undefined")) {
			sParentId = "";
		}
		String text = request.getParameter("text");
		TreeDao dao = new TreeDao();
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
			response.getWriter().write(
					"{\"success\":false,\"msg\":\"添加兄弟菜单失败\"}");
			e.printStackTrace();
		}
		response.getWriter().write(
				"{\"success\":true,\"msg\":\"添加兄弟菜单成功\",\"id\":\"" + fldid
						+ "\",\"text\":\"" + text + "\"}");

	}

}
