package ru.ivanovds.april.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivanovds.april.market.error_handling.ResourceNotFoundException;
import ru.ivanovds.april.market.models.Category;
import ru.ivanovds.april.market.services.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getOneCategoryById(@PathVariable Long id) {
        return categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category doesn't exists: " + id));
    }
}
