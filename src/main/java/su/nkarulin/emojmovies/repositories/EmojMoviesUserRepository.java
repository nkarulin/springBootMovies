package su.nkarulin.emojmovies.repositories;

import org.springframework.data.repository.CrudRepository;
import su.nkarulin.emojmovies.domain.user.EmojMoviesUser;

public interface EmojMoviesUserRepository extends CrudRepository<EmojMoviesUser, String> {
}
