package com.example.demo.service;

import com.example.demo.Repository.SellRepository;
import com.example.demo.entity.Sell;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {
    private final SellRepository sellRepository;
    public SellService(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }
    public List<Sell> findByGoodsId(String goodsId) {
        return sellRepository.findByGoodsId(goodsId);
    }

    public void saveAndFlush(Sell sell) {
        sellRepository.save(sell);
    }

    public Sell findById(String id) {
        return sellRepository.findById(id).orElse(null);
    }

    public void deleteById(String sellId) {
        sellRepository.deleteById(sellId);
    }
}
