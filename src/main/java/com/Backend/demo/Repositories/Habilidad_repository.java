package com.Backend.demo.Repositories;

import com.Backend.demo.Models.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Habilidad_repository extends JpaRepository<Habilidad,Integer>{
    @Query(value = "select *from habilidad where tipo = :tipo", nativeQuery = true)
    List<Habilidad> Get_habilidades_tipo(@Param("tipo") String tipo);
}