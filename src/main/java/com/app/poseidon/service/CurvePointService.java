package com.app.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poseidon.domain.CurvePoint;
import com.app.poseidon.repositories.CurvePointRepository;

import jakarta.validation.Valid;

@Service
public class CurvePointService {
	
	@Autowired
	private CurvePointRepository curvePointRepository;
	
	public List<CurvePoint> getAllCurvePoint () {
		return curvePointRepository.findAll();
	}

	public CurvePoint savecurvePoint(@Valid CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
		
	}

	public CurvePoint getCurvePointById(Integer id) {
		return curvePointRepository.getReferenceById(id);
	}

	public CurvePoint updatecurvePoint(Integer id, @Valid CurvePoint curvePoint) {
		return curvePointRepository.save(curvePoint);
		
	}

	public void deleteCurvePoint(Integer id) {
		curvePointRepository.deleteById(id);
		
	}

}
