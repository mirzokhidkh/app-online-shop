package uz.mk.apponlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.mk.apponlineshop.entity.Address;
import uz.mk.apponlineshop.projection.CustomAddress;

@RepositoryRestResource(path = "address",collectionResourceRel = "list",excerptProjection = CustomAddress.class)
public interface AddressRepository extends JpaRepository<Address,Integer> {
    boolean existsByStreetAndHomeNumber(String street, String homeNumber);
    boolean existsByStreetAndHomeNumberAndIdNot(String street, String homeNumber, Integer id);
}
