package su.nkarulin.emojmovies.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private int year;
    private String image;
    
    @OneToMany(mappedBy = "movie")
    private List<MovieComment> comments;
}
