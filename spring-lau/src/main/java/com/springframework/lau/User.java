package com.springframework.lau;

/**
 * @author Lau wc7625716@163.com
 * Date: 2022/5/9
 * Description: No Description
 */

public class User {

	private Integer id;

	private String username;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
