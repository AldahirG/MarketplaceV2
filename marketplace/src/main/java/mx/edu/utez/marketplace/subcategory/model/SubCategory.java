package mx.edu.utez.marketplace.subcategory.model;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.category.status.model.Status;

import javax.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text", unique = true)
    private  String description;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public SubCategory() {
    }

    public SubCategory(String description, Status status, Category category) {
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public SubCategory(long id, String description, Status status, Category category) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
