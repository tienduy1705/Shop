package com.example.demo.Repository;

import com.example.demo.entity.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository  extends MongoRepository<Goods, String> {
    List<Goods> findByGoodsNameContaining(String keyword);

}
