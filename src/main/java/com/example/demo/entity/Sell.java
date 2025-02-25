package com.example.demo.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "sells")  // MongoDB のコレクション名
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sell {

    @Id
    private String sellId;  // MongoDB の `_id` は通常 String 型 (ObjectId 形式)

    @NotNull
    private Integer sellNum;

    @NotNull
    private Integer sellPrice;

    private String sellDate;

    @DocumentReference
    private Goods goods;


    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum( Integer sellNum) {
        this.sellNum = sellNum;
    }


    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice( Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }
}
