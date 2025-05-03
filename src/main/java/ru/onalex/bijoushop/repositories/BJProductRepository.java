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

    @Query(value="SELECT p.* FROM bj_products p RIGHT JOIN (" +
            "products_groups pg RIGHT JOIN bj_groups g on g.group_id = pg.group_id" +
            ") on p.inner_id = pg.product_id " +
            "WHERE g.group_id = :groupId and p.active=true",nativeQuery = true)
    List<BjProduct> findBjProductsByGroupId(int groupId);
}
