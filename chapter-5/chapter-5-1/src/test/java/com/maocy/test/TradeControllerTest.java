package com.maocy.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.maocy.controller.TradeController;
import com.maocy.entity.Trade;
import com.maocy.mapper.TradeMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class TradeControllerTest {

	@Test
	public void queryTradeTest() throws Exception {
		List<Trade> tradeList = createTradeList(20);
		TradeMapper tradeMapper = mock(TradeMapper.class);
		when(tradeMapper.queryTrade(Long.MAX_VALUE, 20)).thenReturn(tradeList);
		TradeController tradeController = new TradeController(tradeMapper);
		MockMvc mockMvc = standaloneSetup(tradeController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/trade_list.jsp")).build();
		mockMvc.perform(get("/trade-query"))
			.andExpect(view().name("trade_list"))
			.andExpect(model().attributeExists("tradeList"))
			.andExpect(model().attribute("tradeList", hasItems(tradeList.toArray())));
	}
	
	/**
	 * 创建Trade列表
	 * @Title: createTradeList
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年4月12日 下午3:35:35
	 * @param count
	 * @return
	 */
	private List<Trade> createTradeList(int count) {
		List<Trade> tradeList = new ArrayList<Trade>();
		
		for (int i = 0; i < count ; i++) {
			tradeList.add(new Trade(Long.valueOf(i), "0000000" + i));
		}
		
		return tradeList;
	}
}
