package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.OrderType;
import uz.mk.apponlineshop.projection.CustomOrderType;

@RepositoryRestResource(path = "orderType",collectionResourceRel = "list",excerptProjection = CustomOrderType.class)
public interface OrderTypeRepository extends JpaRepository<OrderType,Integer> {

}
