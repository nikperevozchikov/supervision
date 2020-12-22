package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.repository.EventRepository;

import java.util.List;

@Service
public class EventService extends BasicDataService<Event, Integer> {
//    @Autowired
//    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }

//    public List<Event> getByEmployee(Employee employee) {
//        return ((EventRepository) repository).findByEmployeesContains(employee);
//    }

    public List<Event> getByNameIn(List<String> names) {
        return ((EventRepository) repository).findByNameIn(names);
    }
//    public Event getByName(String name) {
//        return ((EventRepository) repository).findByName(name);
//    }
}

