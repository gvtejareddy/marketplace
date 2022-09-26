package com.hm.marketplace.marketplace.Service;

import java.util.List;
import java.util.Map;

import com.hm.marketplace.marketplace.DTO.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product save(Product product);

	Product update(Product product);

	boolean delete(Integer id);

	 Map<String, Object>  getProductPage();

}
