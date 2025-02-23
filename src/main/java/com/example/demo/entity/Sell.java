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

    @Setter
    @Getter
    @Id
    private String sellId;  // MongoDB の `_id` は通常 String 型 (ObjectId 形式)

    @NotNull
    private Integer sellNum;

    @NotNull
    private Integer sellPrice;

    @Setter
    @Getter
    private String sellDate;

    @Setter
    @Getter
    @DBRef  // MongoDB のリファレンス（外部キーの代わり）
    private Goods goods;

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

}
