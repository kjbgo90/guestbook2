package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestBookVo;

@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("action");
		
		if("addList".equals(actionName)) {
			System.out.println("addList 호출!");
			
			GuestBookDao dao = GuestBookDao.getInstance();
			List<GuestBookVo> list = dao.getList();
			
			request.setAttribute("guestList", list);
			
			WebUtil.forword(request, response, "/WEB-INF/addList.jsp");
		} else if("insert".equals(actionName)) {
			System.out.println("insert 실행!");
			
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String content = request.getParameter("content");
			GuestBookVo vo = new GuestBookVo(name, pwd, content);
			
			GuestBookDao dao = GuestBookDao.getInstance();
			dao.insert(vo);
			
			WebUtil.redirect(request, response, "/guestbook2/gb?action=addList");
		} else if("deleteForm".equals(actionName)) {
			System.out.println("deleteForm 호출!");
			
			String no = request.getParameter("no");
			
			WebUtil.forword(request, response, "/WEB-INF/deleteForm.jsp?no="+no);
		} else if("delete".equals(actionName)) {
			System.out.println("delete 실행!");
			
			int no = Integer.parseInt(request.getParameter("no"));
			String pwd = request.getParameter("pwd");
			
			GuestBookVo vo = new GuestBookVo(no, pwd);
			
			GuestBookDao dao = GuestBookDao.getInstance();
			dao.delete(vo);
			
			WebUtil.redirect(request, response, "/guestbook2/gb?action=addList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
