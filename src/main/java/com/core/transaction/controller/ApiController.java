package com.core.transaction.controller;

import com.core.transaction.bo.TransactionService;
import com.core.transaction.cons.TransactionConstant;
import com.core.transaction.dto.HistoryDTO;
import com.core.transaction.dao.HistoryService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history")
public class ApiController {

    @Autowired
    BeanFactory factory;
    TransactionService boTransaction;

    @GetMapping("/mysql/all")
    public List<HistoryDTO> getMysqlHistory(){
        boTransaction = factory.getBean(TransactionConstant.BEAN_MYSQL_BO_TRANSACTION, TransactionService.class);
        return boTransaction.findAllHistory();
    }

    @PostMapping("/mysql/save")
    public HistoryDTO saveMySqlHistory(@RequestBody HistoryDTO history){
        boTransaction = factory.getBean(TransactionConstant.BEAN_MYSQL_BO_TRANSACTION, TransactionService.class);
        return boTransaction.saveHistory(history);
    }

    @GetMapping("/postgres/all")
    public List<HistoryDTO> getPostgresHistory(){
        boTransaction = factory.getBean(TransactionConstant.BEAN_POSTGRESQL_BO_TRANSACTION, TransactionService.class);
        return boTransaction.findAllHistory();
    }

    @PostMapping("/postgres/save")
    public HistoryDTO savePostgresHisory(@RequestBody HistoryDTO history){
        boTransaction = factory.getBean(TransactionConstant.BEAN_POSTGRESQL_BO_TRANSACTION, TransactionService.class);
        return boTransaction.saveHistory(history);
    }

}
