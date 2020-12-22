package ru.perevozchikov.supervision.controller.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.repository.EventRepository;
import ru.perevozchikov.supervision.service.EventService;
import ru.perevozchikov.supervision.service.user.EmployeeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ev")
public class EventController extends BasicDataController<Event, Integer> {
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    public EventController(EventService eventService) {
        super(eventService);
        //this.employeeService = employeeService;
    }
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAll();
    }
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer eventId)
            throws ResourceNotFoundException {
        Event event = eventService.getById(eventId);
                //.orElseThrow(() -> new ResourceNotFoundException("event not found for this id :: " + eventId));

        return ResponseEntity.ok().body(event);
    }
    @PostMapping("/events")
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventService.save(event);
    }
    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Integer eventId,
                                             @Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
        Event event = eventService.getById(eventId);
                //.orElseThrow(() -> new ResourceNotFoundException("event not found for this id :: " + eventId));
        event.setName(eventDetails.getName());
        event.setDateOfEvent((eventDetails.getDateOfEvent()));
        event.setResultOfEvent((eventDetails.getResultOfEvent()));

        final Event updatedEvent = eventService.save(event);
        return ResponseEntity.ok(updatedEvent);
    }
    @DeleteMapping("/events/{id}")
    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Integer eventId)
            throws ResourceNotFoundException {
        Event event = eventService.getById(eventId);
                //.orElseThrow(() -> new ResourceNotFoundException("event not found for this id :: " + eventId));


        eventRepository.delete(event);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

//    @GetMapping("/employee/{employeeId}")
//    public List<Event> getByEmployeeId(@PathVariable Integer employeeId) {
//       Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((EventService) service).getByEmployee(employee);
//    }
}
