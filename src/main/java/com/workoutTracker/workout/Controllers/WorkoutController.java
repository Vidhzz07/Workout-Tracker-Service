package com.workoutTracker.workout.Controllers;


import com.workoutTracker.workout.Entities.Workout;
import com.workoutTracker.workout.Services.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/saveWorkout")
    @ResponseStatus(HttpStatus.CREATED)
    public Workout saveWorkout(@Valid @RequestBody Workout workout)
    {
       return workoutService.saveWorkout(workout);
    }

    @PutMapping("/updateWorkout/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Workout updateWorkout(@PathVariable Long id,@RequestBody Workout workout)
    {
        return workoutService.updateWorkout(id,workout);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Workout getWorkout(@PathVariable Long id)
    {
        return workoutService.getWorkout(id);
    }


    @DeleteMapping("/deleteWorkout/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkout(@PathVariable Long id)
    {
        workoutService.deleteWorkout(id);
    }


}
