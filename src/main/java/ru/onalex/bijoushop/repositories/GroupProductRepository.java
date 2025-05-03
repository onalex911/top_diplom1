package ru.onalex.bijoushop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onalex.bijoushop.entities.ProductGroup;

import java.util.List;

@Repository
public interface GroupProductRepository extends JpaRepository<ProductGroup,Long> {
    // Найти все связи по ID группы
    @Query(value="SELECT t1.product_id FROM products_groups as t1 WHERE t1.group_id = :groupId",nativeQuery = true)
    List<ProductGroup> findByInnerId(int groupId);

    // Найти все связи по ID товара
    @Query(value="SELECT t1.group_id FROM products_groups as t1 WHERE t1.group_id = :groupId",nativeQuery = true)
    List<ProductGroup> findByProductId(int productId);
}
