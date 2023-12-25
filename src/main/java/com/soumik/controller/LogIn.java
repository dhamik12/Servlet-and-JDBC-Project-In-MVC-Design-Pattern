package com.soumik.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soumik.model.Model;


@WebServlet("/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName=request.getParameter("name");
		String userPassword=request.getParameter("password");
		System.out.println(userName+":"+userPassword);
		Model model=new Model();
		model.setName(userName);
		model.setPassword(userPassword);
		model.verify();
		String dbName=model.getName();
		String dbPassword=model.getPassword();
		if(dbName.equals(userName) && dbPassword.equals(userPassword)) {
			System.out.println("Successfully logged in..");
			
			response.sendRedirect("LogInSuccess.jsp");
		}
		else {
			
			response.sendRedirect("LogInFailed.jsp");
			System.out.println("Failed to log in...");
		}
	}

}
