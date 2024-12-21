package vn.edu.iuh.fit.trananhtien.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.trananhtien.backend.models.User;
import vn.edu.iuh.fit.trananhtien.backend.models.UserPricipal;
import vn.edu.iuh.fit.trananhtien.backend.repositories.UserRepository;

import java.util.logging.Logger;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(MyUserDetailService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Searching for user: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.warning("User not found: " + username);
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UserPricipal(user);
    }
}