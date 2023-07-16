package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Category not found"));
    }
}
