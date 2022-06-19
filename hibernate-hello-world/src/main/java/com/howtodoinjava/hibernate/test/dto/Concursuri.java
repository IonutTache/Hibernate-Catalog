package com.howtodoinjava.hibernate.test.dto;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "concursuri")
public class Concursuri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int IdConcursuri;

    @Column(name = "nume")
    private String nume;

    @Column(name = "premiu")
    private int premiu;

}
