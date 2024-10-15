package com.workoutTracker.workout.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    private String userEmail;

    @Size(min=6,max = 50,message = "Password must be between 6 to 50 characters")
    private String password;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Bio cannot be empty")
    private String bio;

    private String imageUrl;

    @NonNull
    private Integer age;

    @NonNull
    private Integer height;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private List<Integer> weight = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonManagedReference
    private List<Workout>workoutList;

}
