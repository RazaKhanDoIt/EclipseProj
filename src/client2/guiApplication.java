package client2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bus.Student;
import data.ConnectionDB;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class guiApplication {
	
	static Connection con = null;
	
	static ArrayList<Student> studentList = null;
	static String query ="";
	static Statement stmt = null;
	static ResultSet rs = null;
	static Student aStudent =null;
	static String ln,fn;
	static String id;
	static int id_key;
	static String request;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = ConnectionDB.getConnection();
					if(con != null)
					{
					 System.out.println("\n\n\t Connection has been established! \n\n");
					}
					else
					{
						System.out.println("\n\n\t Connection could not be established =( \n\n");
					}
					guiApplication window = new guiApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiApplication() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnDisplay = new JButton("Display All");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				query = "Select * from student";
				
				
				try {
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
					
					JOptionPane.showMessageDialog (   null,
		                     studentList,
		                        "String Message",
		                    JOptionPane.INFORMATION_MESSAGE );
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
					
			
				
			}
		});
		btnDisplay.setBounds(43, 81, 85, 21);
		frame.getContentPane().add(btnDisplay);
		
		JButton btnAdd = new JButton("Add User");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String request = null;
				
				id = JOptionPane.showInputDialog( null, "What is your id", "Input", JOptionPane.QUESTION_MESSAGE );
				
				fn = JOptionPane.showInputDialog( null, "What is your first name", JOptionPane.QUESTION_MESSAGE );
			
				ln = JOptionPane.showInputDialog( null,  "What is your last name", JOptionPane.QUESTION_MESSAGE );
				
				aStudent = new Student(Integer.parseInt(id),fn,ln);
				
				request = "insert into Student(id,fn,ln) values(" + aStudent.getId() + ", \'" + aStudent.getFn() +  "\', \'" + aStudent.getLn()+ " \')";
				
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(request);
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 JOptionPane.showMessageDialog (   null,
	                     "Student has now been added to Faculty Database",
	                        "String Message",
	                    JOptionPane.INFORMATION_MESSAGE );
				
				
				
			}
		});
		btnAdd.setBounds(43, 127, 85, 21);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove User");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				id = JOptionPane.showInputDialog( null, "What is your id", "Input", JOptionPane.QUESTION_MESSAGE );
				
				request = " delete from student where id = " +id;
				
				try {
					stmt.executeUpdate(request);
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog (   null,
	                     "Student has now been removed to Faculty Database",
	                        "String Message",
	                    JOptionPane.INFORMATION_MESSAGE );
				
				
				
			}
		});
		btnRemove.setBounds(168, 81, 106, 21);
		frame.getContentPane().add(btnRemove);
		
		JButton btnSearch = new JButton("Search User");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				id = JOptionPane.showInputDialog( null, "What is your id", "Input", JOptionPane.QUESTION_MESSAGE );
				
				query = "select * from student where id = " + id;
				
				
				try {
					stmt = con.createStatement();
					rs= stmt.executeQuery(query);
					
					studentList = new ArrayList<Student>();
					
					if(rs.next())
					{
						id = rs.getString(1);
						fn = rs.getString(2);
						ln = rs.getString(3);
						
						aStudent = new Student(Integer.parseInt(id),fn,ln);
						
						JOptionPane.showMessageDialog (   null,
			                     aStudent,
			                        "String Message",
			                    JOptionPane.INFORMATION_MESSAGE );
						
						
					}
					else
					{
						JOptionPane.showMessageDialog (   null,
			                     "Student has not been found in Faculty Database",
			                        "String Message",
			                    JOptionPane.INFORMATION_MESSAGE );
					}
						
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
				
				
				
			}
		});
		btnSearch.setBounds(168, 127, 106, 21);
		frame.getContentPane().add(btnSearch);
		
		JButton btnModify = new JButton("Modify User");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				String request = null;
				
				id = JOptionPane.showInputDialog( null, "What is your id", "Input", JOptionPane.QUESTION_MESSAGE );
				
				fn = JOptionPane.showInputDialog( null, "What is your first name", JOptionPane.QUESTION_MESSAGE );
			
				ln = JOptionPane.showInputDialog( null,  "What is your last name", JOptionPane.QUESTION_MESSAGE );
				
				aStudent = new Student(Integer.parseInt(id),fn,ln);
				
				request = "update student set fn = '"+ fn + "' , ln =  '"+ ln + "' where id  = "+ id; 
				
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(request);
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 JOptionPane.showMessageDialog (   null,
	                     "Student has now been added to Faculty Database",
	                        "String Message",
	                    JOptionPane.INFORMATION_MESSAGE );
			}
		});
		btnModify.setBounds(299, 81, 106, 21);
		frame.getContentPane().add(btnModify);
	}

}
