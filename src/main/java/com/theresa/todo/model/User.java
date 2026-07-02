package com.theresa.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String email;
    public String password;
    public boolean isDeleted;


    public String getEmail() {
        return email;
    }

    public void setIsDeleted(boolean value) {
        isDeleted = value;
    }

    public String getPassword() {
        return password;
    }
}
