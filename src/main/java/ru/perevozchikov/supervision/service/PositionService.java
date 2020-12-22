package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.repository.PositionRepository;

@Service
public class PositionService extends BasicDataService<Position, Integer> {
    public PositionService(PositionRepository repository) {
        super(repository);
    }

//    public Set<Position> getAllAvailable() {
//        return ((PositionRepository) repository).findAllAvailable();
//    }

    public Position getByName(String name) {
        return ((PositionRepository) repository).findByName(name);
    }
}

