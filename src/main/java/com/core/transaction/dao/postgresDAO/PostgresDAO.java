package com.core.transaction.dao.postgresDAO;

import com.core.transaction.cons.TransactionConstant;
import com.core.transaction.dao.HistoryService;
import com.core.transaction.dto.HistoryDTO;
import com.core.transaction.model.mysql.HistoryMySQL;
import com.core.transaction.model.postgres.HistoryPostgreSQL;
import com.core.transaction.repository.postgres.HistoryPostgreSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(TransactionConstant.BEAN_POSTGRESQL_DAO_TRANSACTION)
public class PostgresDAO implements HistoryService {

    @Autowired
    HistoryPostgreSQLRepository historyPostgreSQLRepository;

    @Override
    public HistoryDTO saveHistory(HistoryDTO historyDTO) {
        try {
            HistoryPostgreSQL objPostgreSql = HistoryPostgreSQL.builder()
                    .provincia(historyDTO.getProvincia())
                    .ciudad(historyDTO.getCiudad())
                    .edad(historyDTO.getEdad())
                    .genero(historyDTO.getGenero())
                    .motivo_desaparicion(historyDTO.getMotivo_desaparicion())
                    .observacion(historyDTO.getObservacion())
                    .fecha_desaparicion(historyDTO.getFecha_desaparicion())
                    .estado(historyDTO.getEstado())
                    .fecha_localizacion(historyDTO.getFecha_localizacion())
                    .build();
            HistoryPostgreSQL objNewPostgreSql = historyPostgreSQLRepository.save(objPostgreSql);
            historyDTO.setId(objNewPostgreSql.getId());
            return historyDTO;
        }catch (Exception e){
            System.out.println("Occurrio un error al crear el regisro en HistoryPostgreSQL "+e.getMessage());
            return null;
        }

    }

    @Override
    public HistoryDTO findByHistoryId(Long id) {
        Optional<HistoryPostgreSQL> objPostgres = historyPostgreSQLRepository.findById(id);
        if (!objPostgres.isPresent()){
            return null;
        }
        HistoryDTO objHistoryDto = HistoryDTO.builder()
                .id(objPostgres.get().getId())
                .provincia(objPostgres.get().getProvincia())
                .ciudad(objPostgres.get().getCiudad())
                .edad(objPostgres.get().getEdad())
                .genero(objPostgres.get().getGenero())
                .motivo_desaparicion(objPostgres.get().getMotivo_desaparicion())
                .observacion(objPostgres.get().getObservacion())
                .fecha_desaparicion(objPostgres.get().getFecha_desaparicion())
                .estado(objPostgres.get().getEstado())
                .fecha_localizacion(objPostgres.get().getFecha_localizacion())
                .build();
        return objHistoryDto;
    }

    @Override
    public List<HistoryDTO> findAllHistory() {
        List<HistoryPostgreSQL> listHistory = historyPostgreSQLRepository.findAll();
        List<HistoryDTO> listHistoryDto = new ArrayList<>();
        listHistory.forEach(x -> {
            HistoryDTO historyDTO = HistoryDTO.builder()
                    .id(x.getId())
                    .provincia(x.getProvincia())
                    .ciudad(x.getCiudad())
                    .edad(x.getEdad())
                    .genero(x.getGenero())
                    .motivo_desaparicion(x.getMotivo_desaparicion())
                    .observacion(x.getObservacion())
                    .fecha_desaparicion(x.getFecha_desaparicion())
                    .estado(x.getEstado())
                    .fecha_localizacion(x.getFecha_localizacion())
                    .build();
            listHistoryDto.add(historyDTO);
        });
        return listHistoryDto;
    }
}
