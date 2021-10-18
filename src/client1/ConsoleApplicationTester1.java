package client1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import bus.Student;
import data.ConnectionDB;

public class ConsoleApplicationTester1 {

	public static void main(String[] args) throws SQLException 
	{
		//-1- connect to oracle database
		Scanner scan = new Scanner(System.in);
		Connection con = null;
		
		ArrayList<Student> studentList = null;
		String query ="";
		Statement stmt = null;
		ResultSet rs = null;
		Student aStudent =null;
		
		
		con = ConnectionDB.getConnection();
		if(con != null)
		{
		 System.out.println("\n\n\t Connection has been established! \n\n");
		}
		else
		{
			System.out.println("\n\n\t Connection could not be established =( \n\n");
		}
		System.out.println("\n\n----------------\n\n");
		
		
		//2 - display
		String id,fn,ln;
		
		query = "Select * from student";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		studentList = new ArrayList<Student>();
		while(rs.next())
		{
			id = rs.getString(1);
			fn = rs.getString(2);
			ln = rs.getString(3);
			
			aStudent = new Student(Integer.parseInt(id),fn,ln);
			studentList.add(aStudent);
		}
		System.out.println(studentList);
		
		//3 search
		int id_key;
		System.out.println("id? : ");
		id_key = scan.nextInt();
		query = "select * from student where id = " + id_key;
		
		
		stmt = con.createStatement();
		rs= stmt.executeQuery(query);
		
		studentList = new ArrayList<Student>();
		
		while(rs.next())
		{
			id = rs.getString(1);
			fn = rs.getString(2);
			ln = rs.getString(3);
			
			aStudent = new Student(Integer.parseInt(id),fn,ln);
			studentList.add(aStudent);
		}
		System.out.println(studentList);

		
		//-4---add new student into faculty database
		
		String request = null;
		System.out.println("id? : ");
		id=scan.next();
		System.out.println("fn ? :");
		fn=scan.next();
		System.out.println("ln ? :");
		ln = scan.next();
		
		aStudent = new Student(Integer.parseInt(id),fn,ln);
		
		request = "insert into Student(id,fn,ln) values(" + aStudent.getId() + ", \'" + aStudent.getFn() +  "\', \'" + aStudent.getLn()+ " \')";
		stmt.executeUpdate(request);
		con.commit();
		
		System.out.println("\n\n--------------\n\n");
        
        //Display the Student table:
        studentList = new ArrayList<Student>();
        while(rs.next())
		{
			id = rs.getString(1);
			fn = rs.getString(2);
			ln = rs.getString(3);
			
			aStudent = new Student(Integer.parseInt(id),fn,ln);
			studentList.add(aStudent);
		}
		System.out.println(studentList);
		
		query = "Select * from student";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		studentList = new ArrayList<Student>();
		while(rs.next())
		{
			id = rs.getString(1);
			fn = rs.getString(2);
			ln = rs.getString(3);
			
			aStudent = new Student(Integer.parseInt(id),fn,ln);
			studentList.add(aStudent);
		}
		System.out.println(studentList);
		
		//5 remove student from faculty database
		
		System.out.println("id ? :");
		id_key =scan.nextInt();
		request = " delete from student where id = " +id_key;
		stmt.executeUpdate(request);
		con.commit();
		
		//display again the student table
		
query = "Select * from student";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		studentList = new ArrayList<Student>();
		while(rs.next())
		{
			id = rs.getString(1);
			fn = rs.getString(2);
			ln = rs.getString(3);
			
			aStudent = new Student(Integer.parseInt(id),fn,ln);
			studentList.add(aStudent);
		}
		System.out.println(studentList);
		
	}

}
