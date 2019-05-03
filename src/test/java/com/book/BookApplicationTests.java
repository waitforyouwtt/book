package com.book;

import com.book.common.Constants;
import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import com.book.utils.SnowflakeIdWorker;
import com.book.utils.SymmetricEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		//userInfoService.batchInsert(list);

	}

	@Test
	public void saveUser(){
		SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
		UserInfo info = new UserInfo();
		info.setUserId(String.valueOf(snowflakeIdWorker.nextId()));
		info.setUserName("范雅轩");
		info.setNickName("fyx");
		info.setPassword(SymmetricEncoder.AESEncode("123456","577521"));
		info.setBirthday(LocalDate.now());
		info.setDeleteFlag(Constants.NO);
		info.setAddress("江苏淮安");
		//userInfoService.save(info);
	}
    @Test
	public void queryUser(){
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName("fyx");
		userInfo.setPassword(SymmetricEncoder.AESEncode("123456","577521"));
		//UserInfo result = userInfoService.login(userInfo);
		//System.out.println("得到的结果："+result);
	}

}
