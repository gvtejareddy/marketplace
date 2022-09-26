package com.hm.marketplace.marketplace.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.marketplace.marketplace.DTO.Product;
import com.hm.marketplace.marketplace.DTO.Score;
import com.hm.marketplace.marketplace.Repository.ScoreRepository;


@Service
public class SearchAndSortServiceIMPL implements SearchAndSortService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Override
	public List<Score> getAllProducts() {
		// TODO Auto-generated method stub
		return scoreRepository.findAll();
	}

	@Override
	public Object getProductPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
