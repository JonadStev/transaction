package com.core.transaction.repository.mysql;

import com.core.transaction.model.mysql.HistoryMySQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMySQLRepository extends JpaRepository<HistoryMySQL, Long> {
}
