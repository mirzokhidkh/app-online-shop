package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.OrderType;

@Projection(types = OrderType.class)
public interface CustomOrderType {
    Integer getId();

    String getName();

    String getDescription();
}
