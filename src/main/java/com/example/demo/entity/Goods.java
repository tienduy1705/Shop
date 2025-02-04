package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name ="goods")
@NoArgsConstructor
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull
    private String name;

    @Column(nullable = true, length = 100)
    private String description;

    @Column
    private Integer stock = 0;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Buy> buys;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
