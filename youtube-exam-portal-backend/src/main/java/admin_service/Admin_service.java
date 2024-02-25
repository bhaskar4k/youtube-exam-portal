package admin_service;

import java.sql.SQLException;

import model.Admin_info;

public class Admin_service {
	private DB_admin_service db_admin_service;
	
	public Admin_service() {
		try {
			this.db_admin_service=new DB_admin_service();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String register_admin(Admin_info admin_info) throws SQLException {
		if(db_admin_service.do_register_admin(admin_info)==true) {
			return "Admin has been registered";
		}
		
		return "Admin not registered/internal server error";
	}
}
