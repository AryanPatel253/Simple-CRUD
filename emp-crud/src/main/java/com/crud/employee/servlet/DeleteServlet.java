package com.crud.employee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.employee.dao.DBDao;
import com.crud.employee.entity.Employee;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		DBDao dao = new DBDao();

		Employee emp = dao.getEmployee(id);

		if (emp != null) {
			dao.deleteEmp(emp);
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("index.jsp");
		}
	}
}
