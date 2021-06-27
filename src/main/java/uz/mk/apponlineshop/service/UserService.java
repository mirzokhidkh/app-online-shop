package uz.mk.apponlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.mk.apponlineshop.entity.Address;
import uz.mk.apponlineshop.entity.User;
import uz.mk.apponlineshop.payload.ApiResponse;
import uz.mk.apponlineshop.payload.UserDto;
import uz.mk.apponlineshop.repository.AddressRepository;
import uz.mk.apponlineshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;


    public ApiResponse add(UserDto userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new ApiResponse("An user with such a phone number already exists", false);
        }

        boolean existsByEmail = userRepository.existsByEmail(userDto.getEmail());

        if (existsByEmail) {
            return new ApiResponse("An user with such a email already exists", false);
        }

        boolean existsByStreetAndHomeNumber = addressRepository.existsByStreetAndHomeNumber(userDto.getStreet(), userDto.getHomeNumber());
        if (existsByStreetAndHomeNumber) {
            return new ApiResponse("An address with such a street and home number already exists", false);
        }


        User user = new User();
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        Address address = new Address();
        address.setStreet(userDto.getStreet());
        address.setHomeNumber(userDto.getHomeNumber());
        Address savedAddress = addressRepository.save(address);
        user.setAddress(savedAddress);

        userRepository.save(user);
        return new ApiResponse("User saved", true);
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return new User();
        }
        return optionalUser.get();
    }

    public ApiResponse edit(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse("User not found", false);
        }

        boolean existsByPhoneNumber = userRepository.existsByPhoneNumberAndIdNot(userDto.getPhoneNumber(), id);
        if (existsByPhoneNumber) {
            return new ApiResponse("An user with such a phone number already exists", false);
        }

        boolean existsByEmail = userRepository.existsByEmailAndIdNot(userDto.getEmail(), id);

        if (existsByEmail) {
            return new ApiResponse("An user with such a email already exists", false);
        }
        User user = optionalUser.get();

        boolean existsAddress = addressRepository
                .existsByStreetAndHomeNumberAndIdNot(userDto.getStreet(), userDto.getHomeNumber(), user.getAddress().getId());
        if (existsAddress) {
            return new ApiResponse("An address with such a street and home number already exists", false);
        }

        Address address = user.getAddress();
        boolean existsByStreetAndHomeNumber = userDto.getStreet().equals(address.getStreet()) && userDto.getHomeNumber().equals(address.getHomeNumber());
        Integer dId = null;
        if (!existsByStreetAndHomeNumber) {
            address = new Address();
            dId = user.getAddress().getId();
        }

        address.setStreet(userDto.getStreet());
        address.setHomeNumber(userDto.getHomeNumber());
        user.setAddress(existsByStreetAndHomeNumber ? address : addressRepository.save(address));
        if (dId != null) {
            addressRepository.deleteById(dId);
        }
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
        return new ApiResponse("User edited", true);

    }


    public boolean deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
