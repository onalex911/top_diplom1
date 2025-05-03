package ru.onalex.bijoushop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onalex.bijoushop.entities.BjGroup;

import java.util.List;

@Repository
public interface BJGroupRepository extends JpaRepository<BjGroup,Integer> {
    @Query(value="SELECT * FROM bj_groups WHERE active=true",nativeQuery = true)
    List<BjGroup> findAllActive();

    BjGroup findByGroupId(int groupId);
}
