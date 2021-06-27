package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.User;

@RepositoryRestResource(path = "user",collectionResourceRel = "list")
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Integer id);
}
