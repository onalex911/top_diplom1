package ru.onalex.bijoushop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="bj_products")
@Data
public class BjProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="inner_id",columnDefinition = "integer")
    @NotNull()
    @NotBlank(message = "Внутренний номер товара должен присутствовать!")
    @NaturalId
    private Integer innerId; //legacy - значение id товара, используется в ссылках и назв. изображений товаров

    @Column(name="articul",columnDefinition = "varchar(50)")
    @NotNull()
    @NaturalId
    @NotBlank(message = "Артикул не может быть пустым!")
    private String articul;

    @Column(name="product_name",columnDefinition = "varchar(max)")
    @NotNull()
    @NotBlank(message = "Наименование товара не может быть пустым!")
    private String productName;

    @Column(name="product_alias",columnDefinition = "varchar(max)")
    @NotNull()
    private String productAlias;

    @Column(name="price",columnDefinition = "integer")
    @NotNull()
    @NotBlank(message = "Цена товара должна присутствовать!")
    @Positive(message = "Цена товара должна быть больше нуля!")
    private Integer price; //целое значение в копейках

    @Column(name="product_order",columnDefinition = "integer")
    private Integer productOrder; //позволяет менять порядок выдачи товара

    @Column(name="action_id",columnDefinition = "integer")
    private Integer actionId; //для связи с таблицей маркетинговых акций

//    good_name character varying(255) NOT NULL,
//    good_alias character varying(255) NOT NULL,
//    price integer,
//    good_order integer DEFAULT 999999,
//    action_id integer,

    @Column(name="active")
    @NotNull
    private Boolean isActive;


    public String getPriceText() {
        return String.format("%.2f", (double)price / 100);
    }

//    public void setPrice(Integer price) {
//        this.price = price;
//    }
    public void setPrice(Double price) {
        this.price = Math.toIntExact(Math.round(price * 100));
    }

    //на случай, если понадобится вывести список групп, которым принадлежит товар
//    @ManyToMany
//    @JoinTable(
//            name="goods_groups",
//            joinColumns = @JoinColumn(name="good_id"),
//            inverseJoinColumns = @JoinColumn(name="group_id")
//    )
//    private List<BjGroup> groups;
}
