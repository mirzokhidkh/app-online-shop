package uz.mk.apponlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Characteristic;
import uz.mk.apponlineshop.entity.Property;
import uz.mk.apponlineshop.projection.CustomProperty;

@RepositoryRestResource(path = "property", collectionResourceRel = "list", excerptProjection = CustomProperty.class)
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    public Page<Characteristic> findAllByCharacteristic_Id(@Param("name") String name, Pageable p);

}
