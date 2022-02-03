package mx.edu.utez.marketplace.category.status.model;

import mx.edu.utez.marketplace.subcategory.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    Optional<SubCategory> findByDescription(String description);
    boolean existsById(long id);
}
