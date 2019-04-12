package com.maocy.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.maocy.controller.HomeController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest {

	@Test
	public void home() throws Exception {
		HomeController homeController = new HomeController();
		MockMvc mockMvc = standaloneSetup(homeController).build();
		mockMvc.perform(get("/home-page")).andExpect(view().name("home"));
	}
}
