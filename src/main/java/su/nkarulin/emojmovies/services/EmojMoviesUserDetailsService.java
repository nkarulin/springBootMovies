package su.nkarulin.emojmovies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import su.nkarulin.emojmovies.repositories.EmojMoviesUserRepository;

@Service
public class EmojMoviesUserDetailsService implements UserDetailsService {

    @Autowired
    EmojMoviesUserRepository emojMoviesUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return emojMoviesUserRepository.findById(username)
                .map(emojMoviesUser -> User.withDefaultPasswordEncoder()
                        .username(emojMoviesUser.getLogin())
                        .password(emojMoviesUser.getPassword())
                        .roles(emojMoviesUser.getRole().name())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(username));

    }
}
