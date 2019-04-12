package com.maocy.mapper;

import java.util.List;

import com.maocy.entity.Trade;

public interface TradeMapper {

	public List<Trade> queryTrade(long max, int count);
}
