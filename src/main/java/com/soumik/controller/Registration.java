package com.soumik.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soumik.model.Model;


@WebServlet("/reg")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("name");
		String userPassword=request.getParameter("password");
		String userCourse=request.getParameter("course");
		String userCountry=request.getParameter("country");
		
		System.out.println(userName+":"+userPassword+":"+userCourse+":"+userCountry);
		Model model=new Model();
		model.setName(userName);
		model.setPassword(userPassword);
		model.setCourse(userCourse);
		model.setCountry(userCountry);
		
		int rows=model.input();
		System.out.println(rows);
		
		if(rows==1) {
			
			response.sendRedirect("success.jsp");
		}
		
		else {
			
			response.sendRedirect("falure.jsp");
		}
		
		
		
	}

}
