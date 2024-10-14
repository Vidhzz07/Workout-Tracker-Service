package com.workoutTracker.workout.Repo;

import com.workoutTracker.workout.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout,Long> {

}
