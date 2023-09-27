package com.app.poseidon.springboot;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.poseidon.domain.BidList;
import com.app.poseidon.service.BidListService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidListService bidListService;

	@Test
	public void bidListTest() {
		BidList bid = new BidList("Account Test", "Type Test", 10d);

		// Save
		bid = bidListService.saveBidList(bid);
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);

		// Update
		bid.setBidQuantity(20d);
		bid = bidListService.updateBidList(null, bid);;
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);

		// Find
		List<BidList> listResult = bidListService.getAllBidList();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getBidListId();
		bidListService.deleteBidList(id);
		BidList bidList = bidListService.getBidListById(id);
		Assert.assertNotNull(bidList);
	}
}
