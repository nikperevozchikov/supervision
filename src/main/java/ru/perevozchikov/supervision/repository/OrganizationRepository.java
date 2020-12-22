package ru.perevozchikov.supervision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Organization;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    // Employee

    List<Organization> findByEmployee(Employee employee);

    //List<Organization> findByEmployeeAndDateTimeBetween(Employee employee, LocalDateTime from, LocalDateTime to);

    Organization findByName(String name);

}
