package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Book;

public class BookDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");		
		String url = "jdbc:mysql://localhost:3306/library";		
		String user = "root";		
		String pwd = "";		
		Connection con = DriverManager.getConnection(url,user,pwd);		
		System.out.println("Connection successfull: ");		
		return con;
		
	}
	public void display() throws ClassNotFoundException, SQLException {
		String sql = "select * from books";
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> books = new ArrayList<>();
		while(rs.next()) {
			
		//	Book book = new Book(rs.getInt("id"),rs.getString("name"),rs.getString("author"));
			
			Book book = new Book();
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setAuthor(rs.getString(3));
			books.add(book);
			
		}
		System.out.println(books);
		
	}
	
	
	
	public void insert() throws ClassNotFoundException, SQLException {
		String sql = "insert into books values(127,'rr','john')";
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int status = stmt.executeUpdate(sql);
		if(status >0) {
			System.out.println("Record inserted successfully:");
			
		}
		else {
			System.out.println("Try again");
		}
	}
	
	public void insertDynamically() throws ClassNotFoundException, SQLException {
		String sql = "insert into books value(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id of the book:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the name of the book");
		String name = sc.nextLine();
		System.out.println("Please enter the author:");
		String author = sc.nextLine();
	    Connection con = getConnection();	
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1,id);
	    pstmt.setString(2, name);
	    pstmt.setString(3, author);
	    int status = pstmt.executeUpdate();
	    if(status>0) {
	    	System.out.println("Record inserted successfully");	    	
	    }
	    else {
	    	System.out.println("Please try agian");
	    }
	}
	public void delete() throws ClassNotFoundException, SQLException {
		String sql = "delete from books where id=122";
		Connection con  = getConnection();
		Statement stmt = con.createStatement();
		int status = stmt.executeUpdate(sql);
		if(status>0)  {
			System.out.println("Record deleted successfully");
		}
		else {
			System.out.println("Sorry try again");
		}
		
	}
	public void update() throws ClassNotFoundException, SQLException {
		display();
		String sql = "update books set id=?,name=?,author=? where id=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please entr the id of the book to be updated:");
		int curr_id = sc.nextInt();
		System.out.println("Please enter the updated id for this book:");
		int updated_id = sc.nextInt();

		System.out.println("Please enter the updated name for this book:");
		String updated_name = sc.nextLine();
		System.out.println("Please enter the updated author for this book:");
		String updated_author = sc.nextLine();
		
		
		try {
			Connection con =getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,updated_id);
			pstmt.setString(2,updated_name);
			pstmt.setString(3,updated_author);
			pstmt.setInt(4,curr_id);
			int status = pstmt.executeUpdate();
			if(status>0) {
				System.out.println("Record updated as given below");				
			}
			else {
				System.out.println("Sorry try again!");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

