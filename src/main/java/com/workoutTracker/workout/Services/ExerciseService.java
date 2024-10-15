package com.workoutTracker.workout.Services;

import com.workoutTracker.workout.Entities.SetData;
import com.workoutTracker.workout.Repo.ExerciseRepo;
import com.workoutTracker.workout.Entities.Exercise;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepo exerciseRepo;


    public Exercise saveExercise(Exercise exercise)
    {
        for(SetData set: exercise.getSetList())
            set.setExercise(exercise);

       return  exerciseRepo.save(exercise);
    }

    public Exercise getExercise(Long id)
    {
        return exerciseRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No exercise found for this id"));
    }

    public void deleteExercise(Long id)
    {
        exerciseRepo.deleteById(id);
    }


}
