package ru.perevozchikov.supervision.controller.data.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.repository.EmployeeRepository;
import ru.perevozchikov.supervision.service.PositionService;
import ru.perevozchikov.supervision.service.user.EmployeeService;
import ru.perevozchikov.supervision.util.Utils;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController extends BasicUserController<Employee> {
    @Autowired
    private PositionService positionService;
//    @Autowired
//    private EmployeeService service;
//    @Autowired
//    private EmployeeRepository repository;

    public EmployeeController(EmployeeService service, PositionService positionService) {
        super(service);
        this.positionService = positionService;

    }

    @Override
    public Employee getById(@PathVariable Integer id) {
        Employee employee = super.getById(id);
        Utils.requireNonNull(employee);
        return employee;
    }

    @GetMapping("/get/position/{positionName}")
    public List<Employee> getByPosition(@PathVariable String positionName) {
        Position position = positionService.getByName(positionName);
        Utils.requireNonNull(position);
        return ((EmployeeService) service).getByPosition(position);
    }


//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return service.getAll();
//    }
//
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = service.getById(employeeId);
//
//        return ResponseEntity.ok().body(employee);
//    }
//
//    @PostMapping("/employees")
//    public Employee createEmployee(@Valid @RequestBody Employee employee) {
//        return service.save(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
//                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = service.getById(employeeId);
//        employee.setRegistrationAddress(employeeDetails.getRegistrationAddress());
//        employee.setPosition(positionService.getByName((employeeDetails.getPosition().getName())));
//
//
//        final Employee updatedEmployee = service.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = service.getById(employeeId);
//
//
//        repository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
//    @GetMapping("/get/event/{eventName}")
//    public List<Employee> getByEventName(@PathVariable String eventName) {
//        Event event = eventService.getByName(eventName);
//        Utils.requireNonNull(event);
//        return ((EmployeeService) service).getByEvent(event);
//    }
}
