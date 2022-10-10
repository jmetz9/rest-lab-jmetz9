package edu.wctc.stockpurchase.controller;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.service.StockPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stockpurchases")
public class StockPurchaseController {

    private StockPurchaseService service;

    @Autowired
    public StockPurchaseController(StockPurchaseService sps) {
        this.service = sps;
    }

    @PostMapping
    public StockPurchase addStockPurchase(@RequestBody StockPurchase newStockPurchase){
        return service.add(newStockPurchase);
    }

    @GetMapping
    public List<StockPurchase> getStockPurchases(){
        return service.getAllStockPurchases();
    }

    @GetMapping("/{purchaseId}")
    public Optional<StockPurchase> getStockPurchase(@PathVariable String purchaseId){
        int id = Integer.parseInt(purchaseId);
        return service.getOneStockPurchase(id);
    }

    @DeleteMapping("/{purchaseId}")
    public String deleteStockPurchase(@PathVariable String purchaseId){
        int id = Integer.parseInt(purchaseId);
        service.deleteStockPurchase(id);
        return "Purchase " + purchaseId + " has been deleted";
    }
}
