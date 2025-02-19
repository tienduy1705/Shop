package com.example.demo.Repository;

import com.example.demo.entity.Buy;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BuyRepository extends MongoRepository<Buy, Long> {
    List<Buy> findByGoodsId(Long goodsId);
}
