package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TodoDao;
import com.db.DBConnect;
import com.entity.ToDoDetails;

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");

		TodoDao dao = new TodoDao(DBConnect.getConn());

		HttpSession session = req.getSession();

		if (dao.addTodo(name, todo, status)) {

			session.setAttribute("sucMsg", "Todo Added Sucessfully.");

			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errMsg", "Todo Added Failed.");
			resp.sendRedirect("add_todo.jsp");
		}

	}

}
