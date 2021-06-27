package uz.mk.apponlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.mk.apponlineshop.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@EqualsAndHashCode
@Data
@Entity
public class Characteristic extends AbsEntity {

}
