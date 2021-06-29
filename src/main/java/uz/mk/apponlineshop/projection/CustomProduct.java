package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Attachment;
import uz.mk.apponlineshop.entity.Characteristic;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.entity.Property;

import java.util.List;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    Double getPrice();

    String getCategory();

    Attachment getPhoto();

    Integer getWarrantyYear();

    String getDescription();

    List<Property> getProperty();
}
