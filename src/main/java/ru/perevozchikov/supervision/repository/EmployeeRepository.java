package ru.perevozchikov.supervision.repository;

import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Position;

import java.util.List;

public interface EmployeeRepository extends UserRepository<Employee> {
    List<Employee> findByPosition(Position position);

    // List<Employee> findByEventsContains(Event event);
}
