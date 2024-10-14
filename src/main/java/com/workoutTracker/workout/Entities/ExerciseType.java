package com.workoutTracker.workout.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class  ExerciseType
{
    private String name;
    private String muscleGroup;
    private Boolean isBodyWeight;
}
