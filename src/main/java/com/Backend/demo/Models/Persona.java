package com.Backend.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;
    
    @NotNull
    @Column(length = 40)
    private String nombre;
    
    @NotNull
    @Column(length = 15)
    private String apellido;
    
    @NotNull
    @Column(length = 15)
    private String telefono;
    
    @NotNull
    @Column(length = 25)
    private String email;
    
    @NotNull
    @Column(length = 45)
    private String direccion;
    
    @NotNull
    @Column(length = 100)
    private String presentacion;
    
    @NotNull
    @Column(length = 45)
    private String titulo;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Educacion> educaciones = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Proyecto> proyectos = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Habilidad> habilidades = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Experiencia_laboral> experiencias_laborales = new HashSet<>();
    
    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;
}