package ru.onalex.bijoushop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="bj_groups")
@Data
public class BjGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="active")
    @NotNull
    private Boolean isActive;

    @Column(name="group_name",columnDefinition = "varchar(50)")
    @NotNull()
    @NotBlank(message = "Имя группы не может быть пустым!")
    private String groupName;

    @Column(name="group_id",columnDefinition = "integer")
    @NotNull()
    @NotBlank(message = "Внутренний номер группы должен присутствовать!")
    @NaturalId
    private Integer groupId; //legacy - значение id группы, используется в ссылках и назв. изображений групп

}
