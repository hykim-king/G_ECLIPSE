package com.pcwk.ehr.ed02;

import com.google.gson.Gson;

public class Main {

	// Java Object to JSON
	public static void main(String[] args) {
		User user = new User("이상무", 23, true);

		// Gson객체 생성
		Gson gson = new Gson();

		String jsonString = gson.toJson(user);

		// JSON Object:{"name":"이상무","age":23,"isActive":true}
		System.out.println("JSON Object:" + jsonString);

	}
}
