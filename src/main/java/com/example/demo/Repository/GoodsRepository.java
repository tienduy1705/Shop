package com.example.demo.Repository;

import com.example.demo.entity.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoodsRepository  extends MongoRepository<Goods, Long> {
    List<Goods> findByNameContaining(String keyword);

}
