package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Users;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryUsers;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessJwtUserDetails implements UserDetailsService {
    @Autowired
    private RepositoryUsers repositoryUsers;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repositoryUsers.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, roles);

        return ud;
    }

}
