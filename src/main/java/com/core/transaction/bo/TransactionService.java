package com.core.transaction.bo;

import com.core.transaction.dto.HistoryDTO;

import java.util.List;

public interface TransactionService {

    HistoryDTO saveHistory(HistoryDTO mySQLDTO);
    HistoryDTO findByHistoryId(Long id);
    List<HistoryDTO> findAllHistory();

}
