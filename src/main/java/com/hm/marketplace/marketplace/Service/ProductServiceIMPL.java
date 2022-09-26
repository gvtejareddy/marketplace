package com.hm.marketplace.marketplace.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hm.marketplace.marketplace.DTO.Product;
import com.hm.marketplace.marketplace.Exception.ResourceNotFoundException;
import com.hm.marketplace.marketplace.Repository.ProductRepository;


@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product update(Product product) {
		productRepository.findById(product.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Product not exist with id: " + product.getId()));

		return productRepository.save(product);
	}

	@Override
	public boolean delete(Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
		productRepository.delete(product);
		return true;
	}

	@Override
	public Map<String, Object> getProductPage() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public  Map<String, Object>getProductPage() {
//		// TODO Auto-generated method stub
//		try {
//		      List<Product> orders = new ArrayList<Product>();
//
//		      if (sort[0].contains(",")) {
//		        // will sort more than 2 fields
//		        // sortOrder="field, direction"
//		        for (String sortOrder : sort) {
//		          String[] _sort = sortOrder.split(",");
//		          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//		        }
//		      } else {
//		        // sort=[field, direction]
//		        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//		      }
//
//		      List<Tutorial> tutorials = new ArrayList<Tutorial>();
//		      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//		      Page<Tutorial> pageTuts;
//		      if (title == null)
//		        pageTuts = tutorialRepository.findAll(pagingSort);
//		      else
//		        pageTuts = tutorialRepository.findByTitleContaining(title, pagingSort);
//
//		      tutorials = pageTuts.getContent();
//
//		      Map<String, Object> response = new HashMap<>();
//		      response.put("tutorials", tutorials);
//		      response.put("currentPage", pageTuts.getNumber());
//		      response.put("totalItems", pageTuts.getTotalElements());
//		      response.put("totalPages", pageTuts.getTotalPages());
//	}

}
