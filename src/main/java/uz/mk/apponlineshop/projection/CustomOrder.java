package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Order;
import uz.mk.apponlineshop.entity.OrderType;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.entity.User;

import java.sql.Timestamp;
import java.util.List;

@Projection(types = Order.class)
public interface CustomOrder {
    Integer getId();

    User getUser();

    Double getTotalSum();

    OrderType getOrderType();

    List<Product> getProduct();

    Timestamp getCreatedAt();
}
