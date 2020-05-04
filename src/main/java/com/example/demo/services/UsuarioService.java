package com.example.demo.services;


import com.example.demo.models.dao.UsuarioDao;
import com.example.demo.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.User;

//import static org.graalvm.compiler.options.OptionType.User;

@Service
public class UsuarioService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioDao client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = client.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Error login");
        }

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

        log.info("Usuario autenticado: " + username);

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
                authorities);

    }

}
