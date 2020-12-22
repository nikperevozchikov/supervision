package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.repository.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationService extends BasicDataService<Organization, Integer> {
    public OrganizationService(OrganizationRepository repository) {
        super(repository);
    }


    public Organization getByName(String name) {
        return ((OrganizationRepository) repository).findByName(name);
    }

    public List<Organization> getByEmployee(Employee employee) {
        return ((OrganizationRepository) repository).findByEmployee(employee);
    }


//    public List<Organization> getByEmployeeAndDateTimeBetween(Employee employee, LocalDateTime from, LocalDateTime to) {
//        return ((OrganizationRepository) repository).findByEmployeeAndDateTimeBetween(employee, from, to);
//    }


}
