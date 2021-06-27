package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Characteristic;

@Projection(types = Characteristic.class)
public interface CustomCharacteristic {
    Integer getId();

    String getName();
}
