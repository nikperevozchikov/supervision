package ru.perevozchikov.supervision.controller.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.repository.OrganizationRepository;
import ru.perevozchikov.supervision.service.EventService;
import ru.perevozchikov.supervision.service.OrganizationService;
import ru.perevozchikov.supervision.service.SupervisionModeService;
import ru.perevozchikov.supervision.service.user.EmployeeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrganizationController {
    @Autowired
    private OrganizationService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EventService eventService;
    @Autowired
    private SupervisionModeService supervisionModeService;

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationService service, EmployeeService employeeService, EventService eventService, SupervisionModeService supervisionModeService) {
        this.service = service;
        this.employeeService = employeeService;
        this.eventService = eventService;
        this.supervisionModeService = supervisionModeService;

    }

    @GetMapping("/organizations")
    public List<Organization> getAllOrganizations() {
        return service.getAll();
    }

    @GetMapping("/organizations/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable(value = "id") Integer organizationId)
            throws ResourceNotFoundException {
        Organization organization = service.getById(organizationId);

        return ResponseEntity.ok().body(organization);
    }

    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('EMPLOYEE')")
    @PostMapping("/organizations")
    public Organization createOrganization(@Valid @RequestBody Organization organization) {
        return service.save(organization);
    }

    @PutMapping("/organizations/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable(value = "id") Integer organizationId,
                                                           @Valid @RequestBody Organization organizationDetails) throws ResourceNotFoundException {
        Organization organization = service.getById(organizationId);
        organization.setName(organizationDetails.getName());
        organization.setOgrn(organizationDetails.getOgrn());
        organization.setDateFoundation(organizationDetails.getDateFoundation());
        organization.setEmployee(employeeService.getById(organizationDetails.getEmployee().getId()));
        organization.setEvent(eventService.getById(organizationDetails.getEvent().getId()));
        organization.setSupervisionMode(supervisionModeService.getById((organizationDetails.getSupervisionMode().getId())));


        final Organization updatedOrganization = service.save(organization);
        return ResponseEntity.ok(updatedOrganization);
    }

    @DeleteMapping("/organizations/{id}")
    public Map<String, Boolean> deleteOrganization(@PathVariable(value = "id") Integer organizationId)
            throws ResourceNotFoundException {
        Organization organization = service.getById(organizationId);


        organizationRepository.delete(organization);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

//    @Override
//    public List<Organization> getAll() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Role role = authentication.getAuthorities().stream().map(a -> Role.valueOf(a.getAuthority())).collect(Collectors.toList()).get(0);
//        Integer userId = Integer.parseInt(((UserDetails) authentication.getPrincipal()).getUsername());
//        List<Organization> organizations;
//        switch (role) {
//            case EMPLOYEE:
//                organizations = getByEmployee(userId);
//                break;
//
//            case ADMIN:
//                organizations = super.getAll();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + role);
//        }
//        return organizations;
//    }

    /* Custom get requests */

    //Employee

//    @GetMapping("/get/employee/{employeeId}")
//    public List<Organization> getByEmployee(@PathVariable Integer employeeId) {
//        Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((OrganizationService) service).getByEmployee(employee);
//    }

//    @GetMapping("/get/employee/datetime/{employeeId}")
//    public List<Organization> getByEmployeeAndDateTime(@PathVariable Integer employeeId,
//                                                       @RequestParam LocalDateTime from,
//                                                       @RequestParam LocalDateTime to) {
//        Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((OrganizationService) service).getByEmployeeAndDateTimeBetween(employee, from, to);
//    }


}
