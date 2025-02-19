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
    public List<Sell> findByGoodsId(Long goodsId) {
        return sellRepository.findByGoodsId(goodsId);
    }

    public Sell saveAndFlush(Sell sell) {
        return sellRepository.save(sell);
    }

    public Sell findById(Long id) {
        return sellRepository.findById(id).orElse(null);
    }

    public void deleteById(Long sellId) {
        sellRepository.deleteById(sellId);
    }
}
