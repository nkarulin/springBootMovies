package su.nkarulin.emojmovies.repositories;

import org.springframework.data.repository.CrudRepository;
import su.nkarulin.emojmovies.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
