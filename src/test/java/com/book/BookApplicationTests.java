package com.book;

import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void contextLoads() {
	}

/*	@Test
	public void save(){

		UserInfo info= new UserInfo();
		info.setUserName("张杰");
		info.setBirthday(LocalDate.now());
		info.setDeleteFlag(true);
		info.setAddress("河南沈丘");

		UserInfo info1 = new UserInfo();
		info.setUserName("张洁");
		info.setBirthday(LocalDate.now());
		info.setDeleteFlag(true);
		info.setAddress("江苏淮安");

		List<UserInfo> list = new ArrayList<>();
		list.add(info);
		list.add(info1);

		userInfoService.batchInsert(list);

	}*/

}
