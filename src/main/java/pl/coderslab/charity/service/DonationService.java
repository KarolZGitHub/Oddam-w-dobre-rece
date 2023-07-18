package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;

    public List<Donation> allDonations() {
        return donationRepository.findAll();
    }

    public Donation findDonationById(long id) {
        return donationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Donation not found"));
    }

    public long getNumberOdBags() {
        long bags = 0;
        for (Donation donation :
                allDonations()) {
            bags += donation.getQuantity();
        }
        return bags;
    }

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public LocalDate getLocalDateFromString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }
}
