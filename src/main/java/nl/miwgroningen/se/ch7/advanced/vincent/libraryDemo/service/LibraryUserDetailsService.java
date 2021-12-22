package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.service;

import nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.repository.LibraryUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Stelt het systeem in staat gebruikers te vinden en authenticeren
 */

@Service
public class LibraryUserDetailsService implements UserDetailsService {

    LibraryUserRepository libraryUserRepository;

    public LibraryUserDetailsService(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return libraryUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " was not found."));
    }
}
