/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package myapp;

import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DemoServlet extends HttpServlet{
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                          throws ServletException, IOException {
    	response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
        //Connection connection;  
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/";
        String dbName="userlogindb?useUnicode=true&character_set_server=utf8mb4";
        String driver="com.mysql.jdbc.Driver";
    //String dbUserName="root";
    //String dbPassword="root";

    try{  
      String Fname = request.getParameter("fname");  
      String Mname = request.getParameter("mname");  
      String Lname = request.getParameter("lname");  
      String Uname = request.getParameter("username");  
      String Emailid = request.getParameter("emailid");  
      String Mobno = request.getParameter("mobno");  
      String Address = request.getParameter("address");  
      String Password1 = request.getParameter("password1");  
      String Password2 = request.getParameter("password2");  

      Class.forName(driver).newInstance();  
      conn = DriverManager.getConnection(url+dbName,"root2", "pass2");
      conn.setAutoCommit(false);
      PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into registerutable (fname, mname, lname, username,"
      		+ "emailid, mobno, address, password1 ,password2) "
      		+ "values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  

      pst.setString(1,Fname);  
      pst.setString(2,Mname);        
      pst.setString(3,Lname);
      pst.setString(4,Uname);
      pst.setString(5,Emailid);
      pst.setString(6,Mobno);
      pst.setString(7,Address);
      pst.setString(8,Password1);
      pst.setString(9,Password2);


      int i = pst.executeUpdate();
      conn.commit(); 
      String msg=" ";
      if(i!=0){  
        msg="Record has been inserted";
        pw.println("<font size='6' color=blue>" + msg + "</font>");  
        request.getRequestDispatcher("index.jsp").forward(request, response);

      


      }  
      else{  
        msg="failed to insert the data";
        pw.println("<font size='6' color=blue>" + msg + "</font>");
       }  
      pst.close();
    }  
    catch (Exception e){  
      pw.println(e);  
    }
    

}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                    throws ServletException, IOException {
            response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
        //Connection connection;  
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/";
        String dbName="userlogindb?useUnicode=true&character_set_server=utf8mb4";
        String driver="com.mysql.jdbc.Driver";
    //String dbUserName="root";
    //String dbPassword="root";

    try{  
      String Fname = request.getParameter("fname");  
      String Mname = request.getParameter("mname");  
      String Lname = request.getParameter("lname");  
      String Uname = request.getParameter("username");  
      String Emailid = request.getParameter("emailid");  
      String Mobno = request.getParameter("mobno");  
      String Address = request.getParameter("address");  
      String Password1 = request.getParameter("password1");  
      String Password2 = request.getParameter("password2");  

      Class.forName(driver).newInstance();  
      conn = DriverManager.getConnection(url+dbName,"root2", "pass2");
      conn.setAutoCommit(false);
      PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into registerutable (fname, mname, lname, username,"
      		+ "emailid, mobno, address, password1 ,password2) "
      		+ "values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  

      pst.setString(1,Fname);  
      pst.setString(2,Mname);        
      pst.setString(3,Lname);
      pst.setString(4,Uname);
      pst.setString(5,Emailid);
      pst.setString(6,Mobno);
      pst.setString(7,Address);
      pst.setString(8,Password1);
      pst.setString(9,Password2);


      int i = pst.executeUpdate();
      conn.commit(); 
      String msg=" ";
      if(i!=0){  
        msg="Record has been inserted";
        pw.println("<font size='6' color=blue>" + msg + "</font>");  
     //   request.getRequestDispatcher("index.jsp").forward(request, response);

      


      }  
      else{  
        msg="failed to insert the data";
        pw.println("<font size='6' color=blue>" + msg + "</font>");
       }  
      pst.close();
    }  
    catch (Exception e){  
      pw.println(e);  
    }
    
    }
}
