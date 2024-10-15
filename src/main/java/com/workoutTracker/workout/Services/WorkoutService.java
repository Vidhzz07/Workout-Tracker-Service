package com.workoutTracker.workout.Services;

import com.workoutTracker.workout.Entities.Exercise;
import com.workoutTracker.workout.Repo.WorkoutRepo;
import com.workoutTracker.workout.Entities.Workout;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepo workoutRepo;

    public Workout saveWorkout(Workout workout)
    {

        for(Exercise exercise : workout.getExerciseList())
            exercise.setWorkout(workout);
        return workoutRepo.save(workout);
    }

    public Workout getWorkout(Long id)
    {
        Workout workout = workoutRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No workout for this id"));

        return workout;
    }

    public Workout updateWorkout(Long id, Workout workout)
    {
        Workout workoutOld = workoutRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No workout for this id"));

        if(workout.getTitle()!=null)
            workoutOld.setTitle(workout.getTitle());

        if(workout.getWorkout_desc()!=null)
            workoutOld.setWorkout_desc(workout.getWorkout_desc());

        if(workout.getExerciseList()!=null || !workout.getExerciseList().isEmpty())
        {
            workoutOld.setExerciseList(workout.getExerciseList());
        }
        if(workout.getTotalVolume()!=null)
        {
            workoutOld.setTotalVolume(workout.getTotalVolume());
        }
        if(workout.getImageUrl()!=null || !workout.getImageUrl().isEmpty())
        {
            workoutOld.setImageUrl(workout.getImageUrl());
        }

        return workoutRepo.save(workoutOld);
    }


    public void deleteWorkout(Long id)
    {
        workoutRepo.deleteById(id);
    }
}
