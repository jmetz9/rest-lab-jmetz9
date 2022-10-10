package edu.wctc.stockpurchase.service;

import edu.wctc.stockpurchase.repo.StockPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPurchaseService {
    private StockPurchaseRepository repo;

    @Autowired
    public StockPurchaseService(StockPurchaseRepository spr) {
        this.repo = spr;
    }
}
