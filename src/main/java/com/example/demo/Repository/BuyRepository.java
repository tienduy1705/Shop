package com.example.demo.Repository;

import com.example.demo.entity.Buy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends MongoRepository<Buy, Long> {
    List<Buy> findByGoodsId(Long goodsId);
}
