package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document(collection = "goods")  // MongoDB のコレクション名
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {

    @Id
    private String id;

    private String goodsName;
    @Setter
    private Integer stock;

    @DBRef
    private List<Buy> buys;

    @DBRef
    private List<Sell> sells;

    /**
     * 購入数の合計 (buyNum)
     */
    public int getTotalBuyQuantity() {
        return buys != null ? buys.stream().mapToInt(Buy::getBuyNum).sum() : 0;
    }

    /**
     * 販売数の合計 (sellNum)
     */
    public int getTotalSellQuantity() {
        return sells != null ? sells.stream().mapToInt(Sell::getSellNum).sum() : 0;
    }

    /**
     * 在庫数 (stock) を動的に計算
     */
    public int getStock() {
        return getTotalBuyQuantity() - getTotalSellQuantity();
    }

}
