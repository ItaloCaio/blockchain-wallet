package application.domain.model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Artwork extends AbstractEntity {

    private String name;
    private String description;
    private String publication_date;
    private String exhibition_date;
    private List<Author> authors;


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
