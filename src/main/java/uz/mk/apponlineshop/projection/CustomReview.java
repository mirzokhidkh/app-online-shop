package uz.mk.apponlineshop.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.entity.Review;
import uz.mk.apponlineshop.entity.User;

import java.sql.Date;

@Projection(types = Review.class)
public interface CustomReview {
    Integer getId();

    String getComment();

    User getUser();

    Double getRating();

    Product getProduct();

    Date getDate();
}
