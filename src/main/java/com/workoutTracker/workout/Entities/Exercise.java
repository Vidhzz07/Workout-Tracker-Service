package com.workoutTracker.workout.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@Entity
@Table(name = "exercise_table")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Embedded
    private ExerciseType type;

    private String comments="";

    @NonNull
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "exercise")
    private List<SetData> setList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "workout_id")
    @JsonIgnore
    private Workout workout;

}
