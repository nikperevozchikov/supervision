package ru.perevozchikov.supervision.controller.data;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.service.PositionService;
import ru.perevozchikov.supervision.util.Utils;

@RestController
@RequestMapping("/api/positions")
public class PositionController extends BasicDataController<Position, Integer> {
    public PositionController(PositionService service) {
        super(service);
    }

    @Override
    public Position getById(@PathVariable Integer id) {
        Position position = service.getById(id);
        Utils.requireNonNull(position);
        return position;
    }

//    @RequestMapping("/get/allAvailable")
//    public Set<Position> getAllAvailable() {
//        return ((PositionService) service).getAllAvailable();
//    }
}
