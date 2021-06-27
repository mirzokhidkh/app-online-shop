package uz.mk.apponlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.mk.apponlineshop.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Category category;

    @OneToOne
    private Attachment photo;

    @Column(nullable = false)
    private Integer warrantyYear;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    private List<Characteristic> characteristic;
}
