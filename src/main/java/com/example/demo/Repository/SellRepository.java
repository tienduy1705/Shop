package com.example.demo.Repository;

import com.example.demo.entity.Sell;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellRepository extends MongoRepository<Sell, Long> {
    List<Sell> findByGoodsId(Long goodsId);
}
