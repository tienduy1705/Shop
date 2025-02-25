package com.example.demo.Controller;

import com.example.demo.entity.Buy;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Sell;
import com.example.demo.service.BuyService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StockController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BuyService buyService;
    @Autowired
    private SellService sellService;

    @GetMapping("/")
    public String index(Model model) {
        List<Goods> goodsList = goodsService.findAll();
        model.addAttribute("goods", goodsList);
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title","商品登録");
        model.addAttribute("goods", new Goods()); // Initialize an empty Goods object
        return "add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Goods goods) {
        goodsService.saveAndFlush(goods);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Goods> goodsList = goodsService.findByGoodsNameContaining(keyword);
        model.addAttribute("goods", goodsList);
        return "index"; // 検索結果を index.html に表示
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Goods goods = goodsService.findById(id);
        List<Buy> buyList = buyService.findByGoodsId(id);
        List<Sell> sellList = sellService.findByGoodsId(id);
        Integer getTotalBuyQuantity = buyList != null ? buyList.stream().mapToInt(Buy::getBuyNum).sum() : 0;
        Integer getTotalSellQuantity = sellList != null ? sellList.stream().mapToInt(Sell::getSellNum).sum() : 0;
        goods.setStock(getTotalBuyQuantity - getTotalSellQuantity);
        model.addAttribute("goods", goods);
        model.addAttribute("buyList", buyList);
        model.addAttribute("sellList", sellList);
        model.addAttribute("title","商品詳細");
        return "detail";
    }
    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Goods goods = goodsService.findById(id);
        model.addAttribute("title","商品更新");
        model.addAttribute("goods", goods);
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String deleteGoods(@PathVariable("id") String id) {
        List<Buy> buyList = buyService.findByGoodsId(id);
        List<Sell> sellList = sellService.findByGoodsId(id);
        if(!buyList.isEmpty() || !sellList.isEmpty()) {
            System.out.println("削除不可: Goods ID " + id + " に関連データがあります");
            return "redirect:/detail/" + id;
        }else{
            goodsService.deleteById(id);
            return "redirect:/";
        }


    }

    @GetMapping("/{goodsId}/addBuy")
    public String addBuy(@PathVariable("goodsId") String goodsId, Model model) {
        Goods goods = goodsService.findById(goodsId);
        Buy buy = new Buy();
        buy.setGoods(goods);
        model.addAttribute("goods",goods);
        model.addAttribute("buy", buy);
        model.addAttribute("title","仕入登録");
        return "addBuy";
    }

    @PostMapping("/{goodsId}/addBuy")
    public String addBuy(@ModelAttribute Buy buy) {
        // Save the goods object (you would likely save it to a database here)
        buyService.saveAndFlush(buy);
        return "redirect:/detail/" + buy.getGoods().getId();
    }

    @GetMapping("/{goodsId}/editBuy/{buyId}")
    public String editBuy(@PathVariable("goodsId") String goodsId,@PathVariable("buyId") String buyId,Model model){
        Goods goods = goodsService.findById(goodsId);
        Buy buy = buyService.findById(buyId);
        model.addAttribute("goods", goods);
        model.addAttribute("buy", buy);
        model.addAttribute("title","仕入編集");
        return "addBuy";
    }

    @GetMapping("/{goodsId}/deleteBuy/{buyId}")
    public String deleteBuy(@PathVariable("goodsId") String goodsId,@PathVariable("buyId") String buyId) {
        buyService.deleteById(buyId);
        return "redirect:/detail/" + goodsId;
    }

    @GetMapping("/{goodsId}/addSell")
    public String addSell(@PathVariable("goodsId") String goodsId, Model model) {
        Goods goods = goodsService.findById(goodsId);
        Sell sell = new Sell();
        sell.setGoods(goods);
        model.addAttribute("goods",goods);
        model.addAttribute("sell", sell);
        model.addAttribute("title","売り登録");
        return "addSell";
    }

    @PostMapping("/{goodsId}/addSell")
    public String addSell(@ModelAttribute Sell sell) {
        // Save the goods object (you would likely save it to a database here)
        sellService.saveAndFlush(sell);
        return "redirect:/detail/" + sell.getGoods().getId();
    }
    @GetMapping("/{goodsId}/editSell/{sellId}")
    public String editSell(@PathVariable("goodsId") String goodsId,@PathVariable("sellId") String sellId, Model model){
        Goods goods = goodsService.findById(goodsId);
        Sell sell = sellService.findById(sellId);
        model.addAttribute("sell", sell);
        model.addAttribute("goods", goods);
        model.addAttribute("title","売り編集");
        return "addSell";
    }
    @GetMapping("/{goodsId}/deleteSell/{sellId}")
    public String deleteSell(@PathVariable("goodsId") String goodsId,@PathVariable("sellId") String sellId) {
        sellService.deleteById(sellId);
        return "redirect:/detail/" + goodsId;
    }


}
