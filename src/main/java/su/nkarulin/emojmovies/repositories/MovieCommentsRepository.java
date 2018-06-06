package su.nkarulin.emojmovies.repositories;

import org.springframework.data.repository.CrudRepository;
import su.nkarulin.emojmovies.domain.Movie;
import su.nkarulin.emojmovies.domain.MovieComment;

public interface MovieCommentsRepository extends CrudRepository<MovieComment, Long> {
}
