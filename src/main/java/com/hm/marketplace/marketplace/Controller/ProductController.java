package com.hm.marketplace.marketplace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.marketplace.marketplace.DTO.Product;
import com.hm.marketplace.marketplace.Response.Response;
import com.hm.marketplace.marketplace.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	   @GetMapping("/")
	    public ResponseEntity<List<Product>> getAll() {
	        try {
	            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   @PostMapping("/save")
	   public ResponseEntity<Response> save(@RequestBody Product product){
	        String message = "";
	        try {
	        	productService.save(product);
	            message = "Order successfully added: ";
	            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	        } catch (Exception e) {
	            message = "Order Save Failed" ;
	            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	        }

	   }
	   
	   @PutMapping("/update")
	   public ResponseEntity<Response> update(@RequestBody Product product){
	        String message = "";
	        try {
	        	productService.update(product);
	            message = "Product successfully added: ";
	            return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	        } catch (Exception e) {
	            message = "Product Save Failed" ;
	            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	        }

	   }
	   
	   public ResponseEntity<Integer> deletePost(@PathVariable Integer id) {

		    var isRemoved = productService.delete(id);

		    if (!isRemoved) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		    return new ResponseEntity<>(id, HttpStatus.OK);
		}
}
