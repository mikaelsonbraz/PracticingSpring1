package com.web.practice.PracticingSpring1.api.models.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idAdmin;

    @Column(length = 100)
    @NotNull
    private String name;

    @Column(length = 100)
    @NotNull
    private String email;

    @Column(length = 16)
    @NotNull
    private String password;


}
