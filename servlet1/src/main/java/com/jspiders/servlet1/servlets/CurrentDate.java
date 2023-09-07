package com.jspiders.servlet1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      resp.setContentType("text/html");
	      resp.setHeader("Refresh", "1");
	      PrintWriter writer = resp.getWriter();
	      Date date = new Date();
	      writer.println("<h1>"+date+"</h1>");
	      System.out.println(date);
	}
	
}
