package ru.perevozchikov.supervision.controller.data.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import ru.perevozchikov.supervision.controller.data.BasicDataController;
import ru.perevozchikov.supervision.model.User;
import ru.perevozchikov.supervision.service.BasicDataService;
import ru.perevozchikov.supervision.service.user.BasicUserService;


public abstract class BasicUserController<T extends User> extends BasicDataController<T, Integer> {
    @Autowired
    private BCryptPasswordEncoder encoder;

    public BasicUserController(BasicDataService<T, Integer> service) {
        super(service);
    }

    @GetMapping("/get/login/{login}")
    public User getByLogin(@PathVariable String login) {
        return ((BasicUserService<?>) service).getByLogin(login);
    }

    @PutMapping("/register")
    public T register(@RequestBody T user) {
        if (getByLogin(user.getPassport())!= null || (user.getEmail() != null && getByLogin(user.getEmail()) != null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return service.save(user);
    }
}