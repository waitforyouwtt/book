package com.book;

import com.book.common.Constants;
import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import jdk.nashorn.internal.ir.IdentNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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

	@Test
	public void save(){
		UserInfo info = new UserInfo();
		info.setUserName("张洁");
		info.setBirthday(LocalDate.now());
		info.setDeleteFlag(Constants.YES);
		info.setAddress("江苏淮安");

		List<UserInfo> list = new ArrayList<>();
		list.add(info);
		userInfoService.batchInsert(list);

	}

	@Test
	public void saveJPA(){
		UserInfo info = new UserInfo();
		info.setUserName("张文洁");
		info.setBirthday(LocalDate.now());
		info.setDeleteFlag(Constants.YES);
		info.setAddress("江苏淮安");

		userInfoService.addUserInfo(info);

	}

}
