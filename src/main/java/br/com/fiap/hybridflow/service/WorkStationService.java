package br.com.fiap.hybridflow.service;

import br.com.fiap.hybridflow.dto.WorkStationDTO;
import br.com.fiap.hybridflow.model.WorkStation;
import br.com.fiap.hybridflow.repository.WorkStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkStationService {

    private final WorkStationRepository repository;

    public WorkStation create(WorkStationDTO.Request request) {
        var station = new WorkStation();
        station.setCode(request.getCode());
        station.setHasMonitor(request.isHasMonitor());
        station.setSilentZone(request.isSilentZone());
        return repository.save(station);
    }

    public List<WorkStation> findAll() {
        return repository.findAll();
    }
}
