package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name ="buy")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyId;

    @Column(nullable = true)
    @NotNull
    private Integer buyNum;

    @Column(nullable = true)
    @NotNull
    private Integer buyPrice;

    @Column(nullable = true)
    private String buyDate;

    @ManyToOne
    @JoinColumn(name = "goods_id", nullable = false)
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}
