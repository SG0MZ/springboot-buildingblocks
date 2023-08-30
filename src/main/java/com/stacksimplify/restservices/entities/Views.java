package com.stacksimplify.restservices.entities;

import java.util.Date;

public class Views {
	
	//external class
	public static class External {
		
	}
	
	//internal class
	public static class Internal extends External {
		
	}
	
	//Classic Example
	//normal view
	public static class Normal {
		private String empid;
		private String name;
		private String department;
	}
	
	public static class Manager extends Normal {
		private Date loginTime;
		private Date logoutTime;
	}
	
	public static class HR extends Normal {
		private String salary;
		private Date lastPromotionDate;
	}
}
