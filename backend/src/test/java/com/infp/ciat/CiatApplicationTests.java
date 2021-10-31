package com.infp.ciat;

import com.infp.ciat.common.properties.ForestProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes = ForestProperties.class)
class CiatApplicationTests {

	@Test
	void contextLoads() {
	}

}
