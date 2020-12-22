package ru.perevozchikov.supervision.service.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.perevozchikov.supervision.model.User;
import ru.perevozchikov.supervision.repository.UserRepository;
import ru.perevozchikov.supervision.service.BasicDataService;


public abstract class BasicUserService<T extends User> extends BasicDataService<T, Integer> implements UserDetailsService {

    public BasicUserService(JpaRepository<T, Integer> repository) {
        super(repository);
    }

    public User getByLogin(String login) {
        return ((UserRepository<T>) repository).findByPassportOrEmail(login, login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return getByLogin(login);
    }
}
