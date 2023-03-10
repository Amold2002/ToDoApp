package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TodoDao;
import com.db.DBConnect;
import com.entity.ToDoDetails;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");

		TodoDao dao = new TodoDao(DBConnect.getConn());
		ToDoDetails t = new ToDoDetails(id, name, todo, status);
		HttpSession session = req.getSession();
		if (dao.updateTodo(t)) {
			session.setAttribute("sucMsg", "Todo Update Sucessfully.");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errMsg", "Todo Update Failed.");
			resp.sendRedirect("edit.jsp");
		}

	}

}
