package su.nkarulin.emojmovies.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class EmojMoviesUser {

    @Id
    @NotNull
    private String login;

    @NotNull
    private String password;

    private UserRole role;
}
