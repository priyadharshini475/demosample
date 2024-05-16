package testScripts;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBTesting {
	//Connection object
   static Connection con=null;
   //Statement Object
   private static Statement stmt;
   //Database url
   public static String DB_URL="jdbc:sqlite:C:\\Users\\priyadharshini.guna\\Desktop\\DB\\TestTrgDB.db";
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
 		  String query = "select * from Students";
 		    ResultSet res = stmt.executeQuery(query);
 		  
 		  while(res.next())
 		  {    
 			  
 			  System.out.println(res.getString(1));  //1-->Column indexa or use column name
 			  System.out.println(" " +res.getString(2));
 			  System.out.println("  "+res.getString(3));
 			  System.out.println(" "+res.getString(4));
 			  System.out.println(" "+res.getString(5));
 		  }
 		 String query1 = "Select name from Students Where Students.id NOT IN (Select studentID FROM Student_course)";
		  ResultSet res1 = stmt.executeQuery(query1);
		  String studName = " ";
		  while(res1.next())
		  {
			  studName = res1.getString("name");
		  }
		  System.out.println("Student name: " +studName);
		  Assert.assertEquals(studName,"Peter");
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

   
