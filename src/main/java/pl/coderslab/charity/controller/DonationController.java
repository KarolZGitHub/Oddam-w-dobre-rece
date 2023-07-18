package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @RequestMapping("/donationForm")
    public String showDonationDorm(Model model) {
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "form";
    }

    @PostMapping("/donationForm")
    public String processDonationForm(@Valid Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        donation.setPickUpTime(LocalTime.now());
        donationService.saveDonation(donation);
        return "redirect:/";
    }
}
