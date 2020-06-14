package dao;

import java.sql.SQLException;

public class DaoRunner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		BookDao dbUtil = new BookDao();
		
		dbUtil.getConnection();
		//dbUtil.insert();
		//dbUtil.delete();
		//dbUtil.display();
		//dbUtil.insertDynamically();
		dbUtil.update();

	}

}
