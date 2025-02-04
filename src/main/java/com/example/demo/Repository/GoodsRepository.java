package com.example.demo.Repository;

import com.example.demo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByNameContaining(String keyword);
}
