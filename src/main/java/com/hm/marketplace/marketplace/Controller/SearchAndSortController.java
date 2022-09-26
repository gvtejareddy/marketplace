package com.hm.marketplace.marketplace.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hm.marketplace.marketplace.DTO.Score;
import com.hm.marketplace.marketplace.Service.ProductService;
import com.hm.marketplace.marketplace.Service.SearchAndSortService;

@RestController
@RequestMapping("/search")
public class SearchAndSortController {
	
	@Autowired
	private SearchAndSortService ss;
	
	@Autowired
	private ProductService productService;
	
	
	 private Sort.Direction getSortDirection(String direction) {
		    if (direction.equals("asc")) {
		      return Sort.Direction.ASC;
		    } else if (direction.equals("desc")) {
		      return Sort.Direction.DESC;
		    }

		    return Sort.Direction.ASC;
		  }
	 
	  @GetMapping("/")
	    public ResponseEntity<List<Score>> getAll() {
	        try {
	            return new ResponseEntity<>(ss.getAllProducts(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	  @GetMapping("/products")
	  public ResponseEntity<Map<String, Object>> getProductPage(
	      @RequestParam(required = false) String name,
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size,
	      @RequestParam(defaultValue = "id,desc") String[] sort) {

		    try {
	            return new ResponseEntity<>(productService.getProductPage(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	  }

}
