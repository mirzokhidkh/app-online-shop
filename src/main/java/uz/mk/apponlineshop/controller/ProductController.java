package uz.mk.apponlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.mk.apponlineshop.entity.Product;
import uz.mk.apponlineshop.entity.Property;
import uz.mk.apponlineshop.repository.ProductRepository;
import uz.mk.apponlineshop.repository.PropertyRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RepositoryRestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    private final PropertyRepository propertyRepository;

    @GetMapping("/product/filter")
    public HttpEntity<?> getAllByFilter(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice,
            @RequestParam(required = false) Optional<Collection<Integer>> idList) {

        List<Property> properties = propertyRepository.findAll();
        Collection<Integer> idsList = properties.stream().map(Property::getId).collect(Collectors.toList());

        if (idList.isPresent()) {
            idsList = idList.get();
        }
        List<Product> products = productRepository.findAllByFilter(minPrice, maxPrice, idsList);
        return ResponseEntity.ok(products);
    }


}
