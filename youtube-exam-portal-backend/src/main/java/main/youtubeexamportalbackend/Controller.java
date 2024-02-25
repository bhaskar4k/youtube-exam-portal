package main.youtubeexamportalbackend;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import admin_service.Admin_service;
import model.Admin_info;

@CrossOrigin
@RestController
public class Controller {
	private Admin_service admin_service;
	
	public Controller() {
		this.admin_service=new Admin_service();
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("Call is coming in hello");
		return "HELLLOOOOOOOOOOOOOOOO.";
	}
	
	@PostMapping("/register_admin")
	public String register_admin(@RequestBody Admin_info admin_info) throws SQLException {
		System.out.println("Call is coming in hello");
		System.out.println(admin_info.getName());
		return admin_service.register_admin(admin_info);
	}
}
