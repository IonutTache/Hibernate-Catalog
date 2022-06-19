package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table( name = "Elev")

    public class Elev {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "id")
        private int idElevi;
        @Column(name = "nume")
        private String nume;
        @Column(name = "prenume")
        private String prenume;
        @Column(name = "medie")
        private double medie;

        @OneToMany
        private List <Concursuri> concursuri;


    }


