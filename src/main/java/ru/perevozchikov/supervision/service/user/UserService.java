package ru.perevozchikov.supervision.service.user;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.User;
import ru.perevozchikov.supervision.repository.UserRepository;

@Service
public class UserService extends BasicUserService<User> {
    public UserService(UserRepository<User> repository) {
        super(repository);
    }
}
