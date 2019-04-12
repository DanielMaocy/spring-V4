package com.maocy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maocy.entity.Trade;
import com.maocy.mapper.TradeMapper;

@Controller
public class TradeController {
	
	private TradeMapper tradeMapper;

	@Autowired
	public TradeController(TradeMapper tradeMapper) {
		super();
		this.tradeMapper = tradeMapper;
	}

	@RequestMapping("/trade-query")
	public String queryTrade(Model mode) {
		List<Trade> list = tradeMapper.queryTrade(Long.MAX_VALUE, 20);
		mode.addAttribute("tradeList", list);
		return "trade_list";
	}
}
