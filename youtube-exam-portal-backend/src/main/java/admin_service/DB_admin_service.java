package admin_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db_config.DB_config;
import model.Admin_info;

public class DB_admin_service {
	private Connection connection;
	private DB_config db_config=new DB_config();
	
	public DB_admin_service() throws SQLException {
		connection=db_config.getConnection();
	}
	
	public Boolean do_register_admin(Admin_info admin_info) throws SQLException {
		Boolean admin_registration_status=false;
		PreparedStatement statement=null;
		
		try {
			String sql = "insert into youtube_exam_portal.admin_info (admin_name,admin_email,admin_password) values(?,?,?)";
			
			statement=connection.prepareStatement(sql);
			statement.setString(1, admin_info.getName());
			statement.setString(2, admin_info.getEmail());
			statement.setString(3, admin_info.getPassword());
			
			int count=statement.executeUpdate();
			
			if(count>0) admin_registration_status=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			statement.close();
		}
		
		return admin_registration_status;
	}
}
