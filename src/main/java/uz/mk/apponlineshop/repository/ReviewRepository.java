package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Review;
import uz.mk.apponlineshop.projection.CustomReview;

@RepositoryRestResource(path = "review",collectionResourceRel = "list",excerptProjection = CustomReview.class)
public interface ReviewRepository extends JpaRepository<Review,Integer> {

}
