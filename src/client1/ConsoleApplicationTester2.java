package client1;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import bus.Student;
import data.ConnectionDB;

public class ConsoleApplicationTester2
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException 
	{
		Scanner scanner = new Scanner(System.in);
		
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
		
		
		
		System.out.println("------Faculty Database------");
		
		
		int choicechosen = 0;
		
		
		do		
		{
			System.out.println("What would you like to do today 1- Display All Info 2- Search 3- Add 4- Remove 5- Modify 6-Exit");
			choicechosen = scanner.nextInt();
			
			switch(choicechosen) 
			{
			
			case 1:
					System.out.println("Displaying All Faculty");
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
					break;
						
				
			case 2:	
				System.out.println("Searching In Faculty Database");
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
				break;
					
			case 3:
				
				System.out.println("Adding to Faculty Database");
				String request = null;
				System.out.println("id? : ");
				id=scan.next();
				System.out.println("fn ? :");
				fn=scan.next();
				System.out.println("ln ? :");
				ln = scan.next();
				
				aStudent = new Student(Integer.parseInt(id),fn,ln);
				
				request = "insert into Student(id,fn,ln) values(" + aStudent.getId() + ", \'" + aStudent.getFn() +  "\', \'" + aStudent.getLn()+ " \')";
				stmt = con.createStatement();
				stmt.executeUpdate(request);
				con.commit();
				
				System.out.println("\n\n--------------\n\n");
		        
		        //Display the Student table:
		        studentList = new ArrayList<Student>();
		        query = "Select * from student";
				
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
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
				break;
				
			case 4:
				System.out.println("Removing from Faculty Database");
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
				break;
				
			case 5:
				System.out.println("Modifying Database");
				request = null;
				System.out.println("id? : ");
				id=scan.next();
				System.out.println("fn ? :");
				fn=scan.next();
				System.out.println("ln ? :");
				ln = scan.next();
				
				aStudent = new Student(Integer.parseInt(id),fn,ln);
				
				request = "update student set fn = '"+ fn + "' , ln =  '"+ ln + "' where id  = "+ id;  
				stmt = con.createStatement();
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
				break;
			
					
			}
			
			
		
		
		} while (choicechosen < 6);
		
		
		
	}

}
