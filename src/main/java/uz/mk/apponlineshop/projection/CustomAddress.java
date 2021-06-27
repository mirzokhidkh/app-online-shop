package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Address;

@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();

    String getStreet();

    String getHomeNumber();

}
