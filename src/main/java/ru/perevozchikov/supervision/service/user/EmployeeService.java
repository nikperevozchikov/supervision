package ru.perevozchikov.supervision.service.user;


import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService extends BasicUserService<Employee> {
    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

    public List<Employee> getByPosition(Position position) {
        return ((EmployeeRepository) repository).findByPosition(position);
    }

//    public List<Employee> getByEvent(Event event) {
//        return ((EmployeeRepository) repository).findByEventsContains(event);
//    }
}
