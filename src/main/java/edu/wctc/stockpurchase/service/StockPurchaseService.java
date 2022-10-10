package edu.wctc.stockpurchase.service;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.repo.StockPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockPurchaseService {
    private StockPurchaseRepository repo;

    @Autowired
    public StockPurchaseService(StockPurchaseRepository spr) {
        this.repo = spr;
    }

    public StockPurchase add(StockPurchase stockPurchase){
        return repo.save(stockPurchase);
    }

    public List<StockPurchase> getAllStockPurchases(){
        List<StockPurchase> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    public Optional<StockPurchase> getOneStockPurchase(int purchaseId){
        return repo.findById(purchaseId);
    }

    public void deleteStockPurchase(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
        }
    }
}
