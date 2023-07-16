package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public List<Institution> allInstitutions() {
       return institutionRepository.findAll();
    }
    public Institution findInstitutionById(long id) {
        return institutionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Institution not found"));
    }
}
