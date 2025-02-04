package com.example.demo.service;

import com.example.demo.Repository.GoodsRepository;
import com.example.demo.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    public Goods saveAndFlush(Goods goods) {
        return goodsRepository.saveAndFlush(goods);
    }
    public Goods findById(Long id){
        return goodsRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        goodsRepository.deleteById(id);
    }
    public List<Goods> findByNameContaining(String keyword){
        if(keyword == null || keyword.isEmpty()){
            return goodsRepository.findAll();
        }
        return goodsRepository.findByNameContaining(keyword);
    }

}
