package com.fanyfahmi.idraggregator.controller;

import com.fanyfahmi.idraggregator.service.strategy.FinanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/data")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping("/{resourceType}")
    public ResponseEntity<Object> getData(@PathVariable String resourceType) {
        return ResponseEntity.ok(financeService.getFinanceData(resourceType));
    }
}
