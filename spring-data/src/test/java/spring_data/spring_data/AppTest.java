package spring_data.spring_data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppTest {
	
	@Test
	public void testeSpring() {
		
		System.out.println("Spring iniciou com sucesso!!");
		
	}
	
}
