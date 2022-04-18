package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "News")
@Data
@NoArgsConstructor
public class News{

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;

    private String tittle;
    private String date;

    @ManyToMany
    private List<Users> user;

    private String content;

}
