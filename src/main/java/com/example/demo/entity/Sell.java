package com.example.demo.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sell")  // MongoDB のコレクション名
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

    @DBRef  // MongoDB のリファレンス（外部キーの代わり）
    private Goods goods;

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    @NotNull
    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(@NotNull Integer sellNum) {
        this.sellNum = sellNum;
    }

    @NotNull
    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(@NotNull Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
