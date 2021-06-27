package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Characteristic;
import uz.mk.apponlineshop.projection.CustomCharacteristic;

@RepositoryRestResource(path = "characteristic",collectionResourceRel = "list",excerptProjection = CustomCharacteristic.class)
public interface CharacteristicRepository extends JpaRepository<Characteristic,Integer> {

}
