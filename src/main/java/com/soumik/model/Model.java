package com.soumik.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	
	private String name;
	private String password;
	private String course;
	private String country;
	
	private Connection connect=null;
	private int rowsAffected=0;
	PreparedStatement	pstmt=null;
	ResultSet rs=null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int input() {
		
		try {
			
			connect=Utility.getDbConnection();
			if(connect!=null) {
				String sql="INSERT INTO MVCProject1 (name,password,course,country) value(?,?,?,?)";
			PreparedStatement	pstmt=connect.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, course);
			pstmt.setString(4, country);
			
			 rowsAffected=pstmt.executeUpdate();
			 
			
			}
		} 
		
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			

		
		 
	
	}
	
	finally {
		
		try {
			
			Utility.closeResourse(rs, pstmt, connect);
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	return rowsAffected;
		
	}
	
	public void verify() {
		
		try {
			
			connect=Utility.getDbConnection();
			if(connect!=null) {
				String sql="select name, password from MVCProject1 where name=?";
				pstmt=connect.prepareStatement(sql);
				if(pstmt!=null) {
					
				pstmt.setString(1, name);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					
					name=rs.getString(1);
					password=rs.getString(2);
				}
				
				
				
				
					
				}
			}
			
			
		} 
		
		
		catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}


