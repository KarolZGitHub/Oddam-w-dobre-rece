package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    // napisać JPQL dla liczby worków
    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer quantity();
}
