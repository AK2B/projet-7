package com.app.poseidon.springboot;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.poseidon.domain.Trade;
import com.app.poseidon.service.TradeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeTests {

	@Autowired
	private TradeService tradeService;

	@Test
	public void tradeTest() {
		Trade trade = new Trade("Trade Account", "Type", 10d);

		// Save
		trade = tradeService.saveTrade(trade);
		Assert.assertNotNull(trade.getTradeId());
		Assert.assertTrue(trade.getAccount().equals("Trade Account"));

		// Update
		trade.setAccount("Trade Account Update");
		trade = tradeService.updateTrade(null, trade);
		Assert.assertTrue(trade.getAccount().equals("Trade Account Update"));

		// Find
		List<Trade> listResult = tradeService.getAllTrade();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = trade.getTradeId();
		tradeService.deleteTrade(id);
		Trade tradeList = tradeService.getTradeById(id);
		Assert.assertNotNull(tradeList);
	}
}
