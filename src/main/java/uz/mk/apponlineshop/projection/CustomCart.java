package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Cart;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.entity.User;

import java.util.List;

@Projection(types = Cart.class)
public interface CustomCart {
    Integer getId();

    User getUser();

    List<Product> getProduct();
}
