package com.example.usermodule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER_DATA")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotBlank(message = "Contact is required")
    @Size(min = 10, max = 10, message = "Contact number must be 10 digits")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be numeric and 10 digits")
    @Column(unique = true, nullable = false)
    private String contact;
    @Column(unique = true)
    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    private String email;
    private String password;
    private Timestamp lastLogin;
    private boolean enabled;

}
