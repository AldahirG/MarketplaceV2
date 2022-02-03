package mx.edu.utez.marketplace.category.status.controller;

import mx.edu.utez.marketplace.category.controller.CategoryService;
import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.subcategory.model.SubCategory;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin(origins = {"*"})

public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return subCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return subCategoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> insert(@RequestBody SubCategoryDTO subcategoryDTO){ //DTO  =  Data Transfer
        return subCategoryService.insert(new SubCategory(subcategoryDTO.getDescription(),subcategoryDTO.getStatus(),subcategoryDTO.getCategory()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody SubCategoryDTO subcategoryDTO){
        return subCategoryService.insert(new SubCategory(subcategoryDTO.getDescription(),subcategoryDTO.getStatus(),subcategoryDTO.getCategory()));
    }



}
