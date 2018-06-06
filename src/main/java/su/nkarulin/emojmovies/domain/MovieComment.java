package su.nkarulin.emojmovies.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MovieComment {
    @Id
    @GeneratedValue
    private long id;
    
    private String author;
    private String text;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}