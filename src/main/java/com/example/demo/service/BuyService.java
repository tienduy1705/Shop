package com.example.demo.service;

import com.example.demo.Repository.BuyRepository;
import com.example.demo.entity.Buy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {
    private final BuyRepository buyRepository;
    public BuyService(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }
    public List<Buy> findByGoodsId(String goodsId) {
        return buyRepository.findByGoodsId(goodsId);
    }

    public void saveAndFlush(Buy buy) {
        buyRepository.save(buy);
    }

    public Buy findById(String id) {
        return buyRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        buyRepository.deleteById(id);
    }
}
