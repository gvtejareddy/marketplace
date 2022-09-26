package com.hm.marketplace.marketplace.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import com.hm.marketplace.marketplace.DTO.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {

	 
}
