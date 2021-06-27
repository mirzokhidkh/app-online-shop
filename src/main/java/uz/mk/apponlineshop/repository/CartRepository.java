package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Cart;
import uz.mk.apponlineshop.projection.CustomCart;

@RepositoryRestResource(path = "cart",collectionResourceRel = "list",excerptProjection = CustomCart.class)
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
