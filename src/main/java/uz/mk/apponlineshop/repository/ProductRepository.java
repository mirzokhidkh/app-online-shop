package uz.mk.apponlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.projection.CustomProduct;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(path = "product",collectionResourceRel = "list",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select distinct p.id, p.active, p.name, p.description, p.price, p.warranty_year,p.category_id,p.photo_id\n " +
            "from product p\n" +
            "         join product_property pp\n " +
            "              on pp.product_id = p.id\n " +
            "where p.price between :minPrice and :maxPrice and\n " +
            "      pp.property_id in(:idList) ",nativeQuery = true)
    List<Product> findAllByFilter(Double minPrice, Double maxPrice,Collection<Integer> idList);

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page<Product> findByCategory_Name(@Param("name") String name, Pageable p);





}
