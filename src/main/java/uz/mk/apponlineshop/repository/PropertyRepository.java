package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Property;
import uz.mk.apponlineshop.projection.CustomProperty;

@RepositoryRestResource(path = "property", collectionResourceRel = "list", excerptProjection = CustomProperty.class)
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
