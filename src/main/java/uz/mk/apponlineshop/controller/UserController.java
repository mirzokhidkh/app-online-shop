package uz.mk.apponlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.mk.apponlineshop.entity.User;
import uz.mk.apponlineshop.payload.ApiResponse;
import uz.mk.apponlineshop.payload.UserDto;
import uz.mk.apponlineshop.repository.UserRepository;
import uz.mk.apponlineshop.service.UserService;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/byNames")
    public HttpEntity<?> getAllByNames() {
        List<User> users = userRepository.findAllByNative(Arrays.asList("A","C"));
        return ResponseEntity.ok(users);
    }


    @GetMapping
    public HttpEntity<?> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody UserDto userDto) {
        ApiResponse response = userService.add(userDto);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@Valid @PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        ApiResponse response = userService.edit(id, userDto);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable Integer id) {
        boolean deleteById = userService.deleteById(id);
        if (deleteById)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
