package testScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWorkDB {
	 static Connection con=null;
	 private static Statement stmt;
	 public static String DB_URL="jdbc:sqlite:C:\\Users\\priyadharshini.guna\\Desktop\\DB\\HomeWorkDB.db";
	   public static String DB_USER = "";
	   public static String DB_PASSWORD = "";
	   
	   @BeforeTest
	   public void setUp() throws Exception{
	 	  try {
	 		  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	 		   stmt=(Statement) con.createStatement();
	 	  }
	 	  catch(Exception e) {
	 		  e.printStackTrace();
	 	  }
	   }
	   @Test
	   public void test()
	   {
	 	  try {
	 		  String query =" Select Employee.empName from employee \n"
	 		  		+ "   join emp_dep on Employee.empId=emp_dep.employeeId\n"
	 		  		+ "   join department on department.depId=emp_dep.departmentId\n"
	 		  		+ "   where department.depName=\"HR\";";
	 		    ResultSet res = stmt.executeQuery(query);
	 		  String name="";
	 		  while(res.next())
	 		  {    
	 			  
	 			   name=res.getString("empName");  //1-->Column indexa or use column name
	 			  
	 		  }
	 		  System.out.println(name);
	 		  Assert.assertEquals(name,"Manogari");
	 		  
	 		  }
	 		
			    catch(Exception e)
	 		  {
	 			  e.printStackTrace();
	 		  }
	 	  }
	   @AfterTest
	   public void tearDown() throws Exception
	   {
	 	  if(con!=null)
	 	  {
	 		  con.close();
	 	  }
		   
	   }
	}

