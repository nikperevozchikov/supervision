package ru.perevozchikov.supervision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perevozchikov.supervision.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    //List<Event> findByEmployeesContains(Employee employee);

    List<Event> findByNameIn(List<String> ids);
    // Event findByName(String name);
}
