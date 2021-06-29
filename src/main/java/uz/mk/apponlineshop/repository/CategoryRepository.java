package uz.mk.apponlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.mk.apponlineshop.entity.Category;
import uz.mk.apponlineshop.projection.CustomCategory;

@RepositoryRestResource(path = "category",collectionResourceRel = "list",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page<Category> findByNameStartsWith(@Param("name") String name, Pageable p);
}
