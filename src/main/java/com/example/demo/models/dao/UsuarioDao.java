package com.example.demo.models.dao;



import com.example.demo.models.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    public Usuario findByUsername(@Param("nombre") String username);

}
