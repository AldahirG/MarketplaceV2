package mx.edu.utez.marketplace.category.status.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.category.model.CategoryRepository;
import mx.edu.utez.marketplace.category.status.model.SubCategoryRepository;
import mx.edu.utez.marketplace.subcategory.model.SubCategory;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SubCategoryService {
    @Autowired
    SubCategoryRepository subCategoryRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("OK", false, subCategoryRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        if (subCategoryRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("OK", false, subCategoryRepository.findById(id)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Subcategoría no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> insert(SubCategory subcategory) {
        Optional<SubCategory> existsSubCategory = subCategoryRepository.findByDescription(subcategory.getDescription());
        if (existsSubCategory.isPresent()) {
            return new ResponseEntity<>(new Message("La Subcategoría ya existe", true, null), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new Message("SubCategoría Registrada", false, subCategoryRepository.saveAndFlush(subcategory)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(SubCategory subCategory) {
        if (subCategoryRepository.existsById(subCategory.getId())) {
            return new ResponseEntity<>(new Message("La subcategoria No existe", true, null), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new Message("La SubCategoria Se Ha Actualizado ", false, subCategoryRepository.saveAndFlush(subCategory)), HttpStatus.BAD_REQUEST);
    }


}
