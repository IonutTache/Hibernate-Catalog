package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idProfesor;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(name = "materie")
    private String materie;


}
