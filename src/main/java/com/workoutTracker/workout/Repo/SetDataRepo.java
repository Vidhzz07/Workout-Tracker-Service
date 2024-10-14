package com.workoutTracker.workout.Repo;

import com.workoutTracker.workout.Entities.SetData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetDataRepo extends JpaRepository<SetData,Long> {
}
