package ru.perevozchikov.supervision.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.perevozchikov.supervision.model.Position;

import java.util.Set;

public interface PositionRepository extends JpaRepository<Position, Integer> {
//    @Query("select p, e from Position p inner join p.employees e")
//    Set<Position> findAllAvailable();

    Position findByName(String name);
}

