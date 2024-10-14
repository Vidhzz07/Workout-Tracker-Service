package com.workoutTracker.workout.Controllers;


import com.workoutTracker.workout.Entities.Exercise;
import com.workoutTracker.workout.Entities.Workout;
import com.workoutTracker.workout.Services.ExerciseService;
import com.workoutTracker.workout.Services.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private WorkoutService workoutService;


    @PostMapping("/saveExercise")
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise saveExercise(@Valid Exercise exercise)
    {
        return exerciseService.saveExercise(exercise);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise getExercise(@PathVariable Long id)
    {
        return exerciseService.getExercise(id);
    }

    @GetMapping("/getAllExercise/{workoutId}")
    public List<Exercise> getAllExercise(@PathVariable Long workoutId)
    {
        Workout workout = workoutService.getWorkout(workoutId);

        return workout.getExerciseList();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteExercise/{id}")
    public void deleteExercise(@PathVariable Long id)
    {
        exerciseService.deleteExercise(id);
    }

}
