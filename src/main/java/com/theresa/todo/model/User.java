package com.theresa.todo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean isDeleted;

    public String getEmail() {
        return email;
    }

    public void setIsDeleted(boolean value) {
        isDeleted = value;
    }

}
