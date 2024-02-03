package com.core.transaction.repository.postgres;

import com.core.transaction.model.postgres.HistoryPostgreSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryPostgreSQLRepository extends JpaRepository<HistoryPostgreSQL, Long> {
}
