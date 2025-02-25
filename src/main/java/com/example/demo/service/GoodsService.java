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

    public void saveAndFlush(Goods goods) {
        goodsRepository.save(goods);
    }
    public Goods findById(String id){
        return goodsRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        goodsRepository.deleteById(id);
    }
    public List<Goods> findByGoodsNameContaining(String keyword){
        if(keyword == null || keyword.isEmpty()){
            return goodsRepository.findAll();
        }
        return goodsRepository.findByGoodsNameContaining(keyword);
    }

}
