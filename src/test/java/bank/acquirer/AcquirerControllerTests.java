package bank.acquirer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BankAppConfig.class)
@WebAppConfiguration
public class AcquirerControllerTests {
		
		@Autowired
		protected WebApplicationContext context;
		
		protected MockMvc mockMvc;
		
		@Before
		public void setUp() {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		}
		
		@Test
		public void hello_ShouldReturnHelloMessage() throws Exception {
			mockMvc.perform(
					get("/api/bank/acquirer/hello"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.content", is("Hello from acquirer bank!")));
		}

}