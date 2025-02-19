package com.example.demo.Repository;

import com.example.demo.entity.Sell;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SellRepository extends MongoRepository<Sell, Long> {
    List<Sell> findByGoodsId(Long goodsId);
}
