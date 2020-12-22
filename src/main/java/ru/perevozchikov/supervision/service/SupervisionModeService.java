package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.SupervisionMode;
import ru.perevozchikov.supervision.repository.SupervisionModeRepository;

import java.util.List;

@Service
public class SupervisionModeService extends BasicDataService<SupervisionMode, Integer> {
    public SupervisionModeService(SupervisionModeRepository repository) {
        super(repository);
    }

    public List<SupervisionMode> getByNameIn(List<String> names) {
        return ((SupervisionModeRepository) repository).findByNameIn(names);
    }
}

