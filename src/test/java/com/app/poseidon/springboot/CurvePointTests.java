package com.app.poseidon.springboot;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.poseidon.domain.CurvePoint;
import com.app.poseidon.service.CurvePointService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {

	@Autowired
	private CurvePointService curvePointService;

	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10d, 30d);

		// Save
		curvePoint = curvePointService.savecurvePoint(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getTerm() == 10);

		// Update
		curvePoint.setTerm(20d);
		curvePoint = curvePointService.updatecurvePoint(null, curvePoint);
		Assert.assertTrue(curvePoint.getTerm() == 20);

		// Find
		List<CurvePoint> listResult = curvePointService.getAllCurvePoint();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = curvePoint.getId();
		curvePointService.deleteCurvePoint(id);
		CurvePoint curvePointList = curvePointService.getCurvePointById(id);
		Assert.assertNotNull(curvePointList);
	}

}
