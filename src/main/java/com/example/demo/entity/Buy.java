package com.example.demo.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "buys")  // MongoDB のコレクション名
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Buy {

    @Id
    private String buyId;  // MongoDB の `_id` は String 型 (ObjectId 形式)

    @NotNull
    private Integer buyNum;

    @NotNull
    private Integer buyPrice;


    private String buyDate;


    @DocumentReference
    private Goods goods;


    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum( Integer buyNum) {
        this.buyNum = buyNum;
    }


    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice( Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods(){
        return goods;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }
}
