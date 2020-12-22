package ru.perevozchikov.supervision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perevozchikov.supervision.model.SupervisionMode;

import java.util.List;

public interface SupervisionModeRepository extends JpaRepository<SupervisionMode, Integer> {

    // List<SupervisionMode> findByEmployeesContains(Employee employee);

    List<SupervisionMode> findByNameIn(List<String> ids);

}
