package bus;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student 
{
	private int id;
	private String fn;
	private String ln;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public Student() {
		super();
	}
	public Student(int id, String fn, String ln) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fn=" + fn + ", ln=" + ln + "]";
	}
	
	//public static database operations
	
//	public static ArrayList<Student> getList() throws SQLException
//	{
//		return StudentDB.getList();
//	}
//	
//	public static int add(Student aStudent) throws SQLException
//	{
//		return StudentDB.insert(aStudent);
//	}
//	
//	public static int remove(int key) throws SQLException
//	{
//		return StudentDB.delete(key);
//	}
//	
//	public static int remove(Student aStudent) throws SQLException
//	{
//		return StudentDB.delete(aStudent);
//	}
//	
}
