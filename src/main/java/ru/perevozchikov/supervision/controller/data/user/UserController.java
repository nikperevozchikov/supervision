package ru.perevozchikov.supervision.controller.data.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perevozchikov.supervision.model.User;
import ru.perevozchikov.supervision.service.user.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController extends BasicUserController<User> {

    public UserController(UserService service) {
        super(service);
    }
}
