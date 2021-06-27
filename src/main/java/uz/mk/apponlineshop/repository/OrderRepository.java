package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Order;
import uz.mk.apponlineshop.entity.OrderType;
import uz.mk.apponlineshop.projection.CustomOrder;
import uz.mk.apponlineshop.projection.CustomOrderType;

@RepositoryRestResource(path = "order",collectionResourceRel = "list",excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
