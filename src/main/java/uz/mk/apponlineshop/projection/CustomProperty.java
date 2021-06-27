package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Property;

@Projection(types = Property.class)
public interface CustomProperty {
    Integer getId();

    String getValue();

    CustomCharacteristic getCharacteristic();
}
