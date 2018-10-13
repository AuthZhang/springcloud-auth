package com.example.demo;

import com.example.demo.controller.HelloController;
import com.example.demo.dao.TempTestUserDao;
import com.example.demo.entity.TempTestUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private TempTestUserDao tempTestUserDao;

	/**
	 * aop，加载完类后，方法执行之前，进行mockMvc的初始化
	 * @Author zhangyu
	 * @Description
	 * @Date 2018/9/27
	 * @Param
	 * @return
	 **/
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void contextLoads() {
	}


	@Test
	public void getHello() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUser").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void saveGetAllUser(){
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String date =dateFormat.format(new Date());
		this.tempTestUserDao.save(new TempTestUser("aa", "aa_password", "aa", "aa123456",date));
	}
	@Test
	public void getAllUser(){
		List<TempTestUser> result = this.tempTestUserDao.findAll();
		System.out.println();
	}

}
