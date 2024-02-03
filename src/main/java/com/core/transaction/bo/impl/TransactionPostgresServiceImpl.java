package com.core.transaction.bo.impl;

import com.core.transaction.cons.TransactionConstant;
import com.core.transaction.dao.HistoryService;
import com.core.transaction.dto.HistoryDTO;
import com.core.transaction.bo.TransactionService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(TransactionConstant.BEAN_POSTGRESQL_BO_TRANSACTION)
public class TransactionPostgresServiceImpl implements TransactionService {

    @Autowired
    BeanFactory factory;
    HistoryService daoHistory;

    @Override
    public HistoryDTO saveHistory(HistoryDTO mySQLDTO) {
        daoHistory = factory.getBean(TransactionConstant.BEAN_POSTGRESQL_DAO_TRANSACTION, HistoryService.class);
        HistoryDTO historyDTO = daoHistory.saveHistory(mySQLDTO);
        return historyDTO;
    }

    @Override
    public HistoryDTO findByHistoryId(Long id) {
        daoHistory = factory.getBean(TransactionConstant.BEAN_POSTGRESQL_DAO_TRANSACTION, HistoryService.class);
        HistoryDTO historyDTO = daoHistory.findByHistoryId(id);
        return historyDTO;
    }

    @Override
    public List<HistoryDTO> findAllHistory() {
        daoHistory = factory.getBean(TransactionConstant.BEAN_POSTGRESQL_DAO_TRANSACTION, HistoryService.class);
        List<HistoryDTO> historyDTOList = daoHistory.findAllHistory();
        return historyDTOList;
    }
}
