package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.User;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(path = "user",collectionResourceRel = "list")
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Integer id);

    @Query(value = "select *from users where name in(:names)",nativeQuery = true)
    List<User> findAllByNative(Collection<String> names);
}
