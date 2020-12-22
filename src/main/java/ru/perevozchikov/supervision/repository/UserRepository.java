package ru.perevozchikov.supervision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perevozchikov.supervision.model.User;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Integer> {

    T findByPassportOrEmail(String passport, String email);
}
