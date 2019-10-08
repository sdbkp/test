package spring.project.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.test.mapper.DBMapper;

@Service
public class DBServiece {
	
//	@Autowired
//	DBMapper dbm;
	
	public void dbTest() {
//		System.out.println(dbm.dbTest());
	}
	
//	public void ads() {
//		System.out.println(dbm.getAds().toString());
//	}
	
	public void test() {
		System.out.println("DBService.test()");
	}
	
}
