package su.nkarulin.emojmovies.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class EmojMoviesUser {

    @Id
    private String login;
    private String password;
}
