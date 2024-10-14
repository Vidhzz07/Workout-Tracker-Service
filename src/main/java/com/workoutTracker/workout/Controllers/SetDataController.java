package com.workoutTracker.workout.Controllers;


import com.workoutTracker.workout.Entities.Exercise;
import com.workoutTracker.workout.Entities.SetData;
import com.workoutTracker.workout.Services.ExerciseService;
import com.workoutTracker.workout.Services.SetDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/setData")
public class SetDataController {


    @Autowired
    private SetDataService setDataService;

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/saveSetData")
    @ResponseStatus(HttpStatus.CREATED)
    public SetData saveSetData(@Valid SetData setData)
    {
        return setDataService.saveSet(setData);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SetData getSetData(@PathVariable Long id)
    {
        return setDataService.getSet(id);
    }

    @GetMapping("/getAllSetData/{exerciseId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SetData> getAllSetData(@PathVariable Long exerciseId)
    {
        Exercise exercise = exerciseService.getExercise(exerciseId);
        return  exercise.getSetList();

    }

    @DeleteMapping("/deleteSetData/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSetData(@PathVariable Long id)
    {
        setDataService.deleteSet(id);
    }
}
