package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
public class Users{

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;

    @Size(min = 2, message = "Не меньше 5 символов")
    private String username;

    @Size(min = 2, message = "Не меньше 5 знаков")
    private String password;

    @Size(min = 2, message = "Не меньше 5 символов")
    private String name;

    @Size(min = 2, message = "Не меньше 5 символов")
    private String surname;

    private String role;
}
