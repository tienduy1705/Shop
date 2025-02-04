package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name ="sell")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellId;

    @Column(nullable = true)
    @NotNull
    private Integer sellNum;

    @Column(nullable = true)
    @NotNull
    private Integer sellPrice;

    @Column
    private String sellDate;

    @ManyToOne
    @JoinColumn(name = "goods_id", nullable = false)
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Long getSellId() {
        return sellId;
    }

    public void setSellId(Long sellId) {
        this.sellId = sellId;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }
}
