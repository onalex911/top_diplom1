package ru.onalex.bijoushop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
    name = "products_groups",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id", "group_id"})  // товар может быть привязан к группе один раз
    }
)
@Data
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private BjProduct bjProduct;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private BjGroup bjGroup;
}
