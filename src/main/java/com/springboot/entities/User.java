package com.springboot.entities;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name can't be null")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Age can't be null")
    private Integer age;

    @Column(name = "date_of_birth")
    @Past(message = "DOB has only past date")
    private LocalDate dob;

}
