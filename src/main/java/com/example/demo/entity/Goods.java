package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goods")  // MongoDB のコレクション名
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {

    @Id
    private String id;

    private String goodsName;
    private Integer goodsPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
