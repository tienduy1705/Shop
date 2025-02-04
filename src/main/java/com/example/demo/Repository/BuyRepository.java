package com.example.demo.Repository;

import com.example.demo.entity.Buy;
import com.example.demo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuyRepository extends JpaRepository<Buy, Long> {
    List<Buy> findByGoodsId(Long goodsId);
}
