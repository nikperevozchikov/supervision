package ru.perevozchikov.supervision.controller.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.perevozchikov.supervision.model.SupervisionMode;
import ru.perevozchikov.supervision.repository.SupervisionModeRepository;
import ru.perevozchikov.supervision.service.SupervisionModeService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SupervisionModeController extends BasicDataController<SupervisionMode, Integer> {
    @Autowired
    private SupervisionModeService supervisionModeService;
    @Autowired
    private SupervisionModeRepository supervisionModeRepository;

    public SupervisionModeController(SupervisionModeService supervisionModeService) {
        super(supervisionModeService);
    }


    @GetMapping("/supervisionmodes")
    public List<SupervisionMode> getAllSupervisionmodes() {
        return supervisionModeService.getAll();
    }

    @GetMapping("/supervisionmodes/{id}")
    public ResponseEntity<SupervisionMode> getSupervisionmodeById(@PathVariable(value = "id") Integer supervisionmodeId)
            throws ResourceNotFoundException {
        SupervisionMode supervisionMode = supervisionModeService.getById(supervisionmodeId);
        // .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + supervisionmodeId));
        return ResponseEntity.ok().body(supervisionMode);
    }

    @PostMapping("/supervisionmodes")
    public SupervisionMode createSupervisionmode(@Valid @RequestBody SupervisionMode supervisionMode) {
        return supervisionModeService.save(supervisionMode);
    }

    @PutMapping("/supervisionmodes/{id}")
    public ResponseEntity<SupervisionMode> updateSupervisionmode(@PathVariable(value = "id") Integer supervisionmodeId,
                                                                 @Valid @RequestBody SupervisionMode supervisionModeDetails) throws ResourceNotFoundException {
        SupervisionMode supervisionMode = supervisionModeService.getById(supervisionmodeId);
        //.orElseThrow(() -> new ResourceNotFoundException("supervisionmodenot found for this id :: " + supervisionmodeId));
        supervisionMode.setName(supervisionModeDetails.getName());
        supervisionMode.setResultOfEvent(supervisionModeDetails.getResultOfEvent());

        final SupervisionMode updatedSupervisionmode = supervisionModeService.save(supervisionMode);
        return ResponseEntity.ok(updatedSupervisionmode);
    }

    @DeleteMapping("/supervisionmodes/{id}")
    public Map<String, Boolean> deleteSupervisionmode(@PathVariable(value = "id") Integer supervisionmodeId)
            throws ResourceNotFoundException {
        SupervisionMode supervisionMode = supervisionModeService.getById(supervisionmodeId);
        // .orElseThrow(() -> new ResourceNotFoundException("supervisionmode not found for this id :: " + supervisionmodeId));

        supervisionModeRepository.delete(supervisionMode);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

//    @GetMapping("/employee/{employeeId}")
//    public List<SupervisionMode> getByEmployeeId(@PathVariable Integer employeeId) {
//       Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((SupervisionModeService) service).getByEmployee(employee);
//    }
}
