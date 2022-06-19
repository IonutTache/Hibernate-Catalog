package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clasa")
public class Clasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idClasa;

    @Column(name = "NUME_CLASA")
    private String numeClasa;

    @OneToMany
    private List<Elev> elev;

    @OneToOne
    private Profesor profesor;
}
