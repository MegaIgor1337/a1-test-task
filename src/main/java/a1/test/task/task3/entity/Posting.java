package a1.test.task.task3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matDoc;
    private String item;
    private LocalDate docDate;
    private LocalDate postDate;
    private String materialDescription;
    private Integer quantity;
    private String bun;
    private BigDecimal amountLc;
    private String crcy;
    private String username;
    private boolean authorizedDelivery;
}
