package com.hm.marketplace.marketplace.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hm.marketplace.marketplace.DTO.Product;
import com.hm.marketplace.marketplace.DTO.Score;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	List<Score> findByNameContaining(String name, Sort sort);
}
