package com.workoutTracker.workout.Services;


import com.workoutTracker.workout.Repo.SetDataRepo;
import com.workoutTracker.workout.Entities.SetData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetDataService {

    @Autowired
    private SetDataRepo setDataRepo;

    public SetData saveSet(SetData setData)
    {
      return setDataRepo.save(setData);
    }

    public SetData getSet(Long id)
    {
        return setDataRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("SetData not found for this id"));
    }

    public void deleteSet(Long id)
    {
        setDataRepo.deleteById(id);
    }

}
