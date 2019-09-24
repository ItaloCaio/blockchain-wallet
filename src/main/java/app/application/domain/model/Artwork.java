package app.application.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artwork extends AbstractEntity {

    private String name;
    private String description;
    private String publication_date;
    private String exhibition_date;
    @JsonIgnoreProperties("artworks")
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="author_artworks", joinColumns=
        {@JoinColumn(name="artworks_id")}, inverseJoinColumns=
        {@JoinColumn(name="authors_id")})
    private List<Author> authors;

    public Artwork(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getExhibition_date() {
        return exhibition_date;
    }

    public void setExhibition_date(String exhibition_date) {
        this.exhibition_date = exhibition_date;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
