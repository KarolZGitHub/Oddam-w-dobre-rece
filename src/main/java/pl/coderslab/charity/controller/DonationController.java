package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        return categoryService.allCategories();
    }

    @ModelAttribute("allCategories")
    public List<Institution> allInstitutions() {
        return institutionService.allInstitutions();
    }

    @RequestMapping("/donationForm")
    public String showDonationDorm(Model model) {
        model.addAttribute(new Donation());
        return "donationForm";
    }

    @PostMapping("/donationForm")
    public String processDonationForm(@Valid Donation donation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "donationForm";
        }
        donationService.saveDonation(donation);
        return "redirect:/";
    }
}
