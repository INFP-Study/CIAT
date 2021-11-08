package com.infp.ciat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class CiatApplicationTests {

	@Test
	void contextLoads() {
	}

	@BeforeAll
	public static void beforeAll() {
		String jasypt_password = System.getenv("jasypt.encryptor.password");
		System.setProperty("jasypt.encryptor.password", jasypt_password);
	}

}
