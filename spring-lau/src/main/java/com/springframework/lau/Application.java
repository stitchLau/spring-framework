package com.springframework.lau;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lau wc7625716@163.com
 * Date: 2022/5/9
 * Description: No Description
 */

public class Application {

	public static void main(String[] args) throws Exception {
		// 这些内容应该是读取xml配置文件获取
		Class<?> clazz = Class.forName("com.springframework.lau.User");
		Object instance = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getDeclaredMethods();
		List<Method> methodList = Arrays.asList(methods);
		for (Field field : fields) {
			field.setAccessible(true);

			// id => setId
			String setter = "set" + field.getName().substring(0, 1).toUpperCase(Locale.ROOT) + field.getName().substring(1);

			methodList.forEach(m -> m.setAccessible(true));
			List<Method> setterMethod = methodList.stream().filter(m -> setter.equals(m.getName())).collect(Collectors.toList());
			if (setterMethod.size() == 0) {
				throw new NoSuchMethodException();
			}
			Method method = setterMethod.get(0);
			if ("setId".equals(method.getName())) {
				method.invoke(instance, 1000);
			} else {
				// username
				method.invoke(instance, "haha");
			}
		}

		System.out.println(instance);
	}

}
