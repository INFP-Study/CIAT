package com.infp.ciat;

import com.infp.ciat.forest.service.ForestApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(properties = "spring.profiles.active:test")
class CiatApplicationTests {

	@Autowired
	ForestApiService forestApiService;

	@Test
	void contextLoads() {
	}

}
