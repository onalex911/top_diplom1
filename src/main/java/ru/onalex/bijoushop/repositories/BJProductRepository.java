package ru.onalex.bijoushop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onalex.bijoushop.entities.BjProduct;

import java.util.List;

@Repository
public interface BJProductRepository extends JpaRepository<BjProduct,Integer>, JpaSpecificationExecutor<BjProduct> {
    @Query(value="SELECT * FROM bj_products WHERE active=true",nativeQuery = true)
    List<BjProduct> findAllActive();

    List<BjProduct> findByGroupId(int groupId);


}
