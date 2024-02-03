package com.core.transaction.dao;

import com.core.transaction.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {

    HistoryDTO saveHistory(HistoryDTO historyDTO);
    HistoryDTO findByHistoryId(Long id);
    List<HistoryDTO> findAllHistory();

}
