package com.lim.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lim.dao.TreeDao;


public class EasyTreeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 TreeDao dao=new TreeDao();
		 String id=request.getParameter("id");
		 String text=request.getParameter("text");
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>删除id:"+id+"?????text:"+text);
		 try {
			dao.delete(id);
		} catch (Exception e) {
			 response.getWriter().write("{\"success\":false,\"msg\":\"删除菜单失败,原因"+e.toString()+"\"}");
			e.printStackTrace();
		}
		 response.getWriter().write("{\"success\":true,\"msg\":\"删除菜单成功,名称>" + text + ",id>" + id + "\"}");
	}

}
