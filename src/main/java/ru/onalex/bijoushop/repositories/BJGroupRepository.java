package ru.onalex.bijoushop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.onalex.bijoushop.entities.BjGroup;

import java.util.List;

public interface BJGroupRepository extends JpaRepository<BjGroup,Integer> {
    @Query(value="SELECT * FROM bj_groups WHERE active=true",nativeQuery = true)
    List<BjGroup> findAllActive();
}
