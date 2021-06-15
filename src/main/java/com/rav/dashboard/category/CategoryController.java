package com.rav.dashboard.category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String categoriesList(Model model){
        List<Category>categoryList = categoryService.findAll();
        model.addAttribute("categories",categoryList);
        return "index";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Category category = new Category();
        model.addAttribute("categories", category);
        return "forms/categoryForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        Category theProducts = categoryService.findById(id);
        model.addAttribute("categories", theProducts);
        return "forms/categoryForm";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category")Category category){
        categoryService.save(category);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {
        categoryService.deleteById(theId);
        return "redirect:/list";

    }

}
