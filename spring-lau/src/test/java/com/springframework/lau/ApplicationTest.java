package com.springframework.lau;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lau wc7625716@163.com
 * Date: 2022/5/9
 * Description: No Description
 */
class ApplicationTest {

	@Test
	public void testIoC() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
	}

}