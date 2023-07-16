package pl.coderslab.charity.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donation")
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category categoryList;
    @OneToOne(fetch = FetchType.EAGER)
    private Institution institution;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    @Length(min = 6, max = 6)
    private String zipCode;
    @NotNull
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;
    private String pickUpComment;
}
