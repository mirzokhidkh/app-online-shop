package uz.mk.apponlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private Double totalSum;

    @ManyToOne
    private OrderType orderType;

    @ManyToMany
    private List<Product> product;

    @Column(nullable = false)
    private Timestamp createdAt;
}
