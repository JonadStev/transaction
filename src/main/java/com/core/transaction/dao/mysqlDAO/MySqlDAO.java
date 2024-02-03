package com.core.transaction.dao.mysqlDAO;

import com.core.transaction.cons.TransactionConstant;
import com.core.transaction.dao.HistoryService;
import com.core.transaction.dto.HistoryDTO;
import com.core.transaction.model.mysql.HistoryMySQL;
import com.core.transaction.repository.mysql.HistoryMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(TransactionConstant.BEAN_MYSQL_DAO_TRANSACTION)
public class MySqlDAO implements HistoryService {

    @Autowired
    HistoryMySQLRepository historyMySQLRepository;

    @Override
    public HistoryDTO saveHistory(HistoryDTO historyDTO) {
        try {
            HistoryMySQL objMysql = HistoryMySQL.builder()
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
            historyMySQLRepository.save(objMysql);
            historyDTO.setId(objMysql.getId());
            return historyDTO;
        }catch (Exception e){
            System.out.println("Occurrio un error al crear el regisro en HistoryMYSQL "+e.getMessage());
            return null;
        }

    }

    @Override
    public HistoryDTO findByHistoryId(Long id) {
        Optional<HistoryMySQL> objMySql = historyMySQLRepository.findById(id);
        if (!objMySql.isPresent()){
            return null;
        }
        HistoryDTO objHistoryDto = HistoryDTO.builder()
                .id(objMySql.get().getId())
                .provincia(objMySql.get().getProvincia())
                .ciudad(objMySql.get().getCiudad())
                .edad(objMySql.get().getEdad())
                .genero(objMySql.get().getGenero())
                .motivo_desaparicion(objMySql.get().getMotivo_desaparicion())
                .observacion(objMySql.get().getObservacion())
                .fecha_desaparicion(objMySql.get().getFecha_desaparicion())
                .estado(objMySql.get().getEstado())
                .fecha_localizacion(objMySql.get().getFecha_localizacion())
                .build();
        return objHistoryDto;
    }

    @Override
    public List<HistoryDTO> findAllHistory() {
        List<HistoryMySQL> listHistoryMysql = historyMySQLRepository.findAll();
        List<HistoryDTO> listHistoryDto = new ArrayList<>();
        listHistoryMysql.forEach(x -> {
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
