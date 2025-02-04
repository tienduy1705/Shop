package com.example.demo.Repository;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Long> {
    List<Sell> findByGoodsId(Long goodsId);
}
