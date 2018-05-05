package su.nkarulin.emojmovies.repositories;

import org.springframework.data.repository.CrudRepository;
import su.nkarulin.emojmovies.domain.EmojMoviesUser;

public interface EmojMoviesUserRepository extends CrudRepository<EmojMoviesUser, String> {
}
