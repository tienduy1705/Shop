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
    public List<Buy> findByGoodsId(Long goodsId) {
        return buyRepository.findByGoodsId(goodsId);
    }

    public Buy saveAndFlush(Buy buy) {
        return buyRepository.saveAndFlush(buy);
    }

    public Buy findById(Long id) {
        return buyRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        buyRepository.deleteById(id);
    }
}
