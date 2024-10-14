package com.workoutTracker.workout.Services;


import com.workoutTracker.workout.Entities.User;
import com.workoutTracker.workout.Repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User registerUser(User user)
    {
       return userRepo.save(user);
    }

    public User getUser(Long id)
    {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found by id "+ id));
    }

    public User updateUser(Long id,User user)
    {
        User oldUser = userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found by id "+ id));

        if(user.getName()!=null)
            oldUser.setName(user.getName());

        if(user.getAge()!=null)
            oldUser.setAge(user.getAge());

        if(user.getImageUrl()!=null)
            oldUser.setImageUrl(user.getImageUrl());

        if(user.getHeight()!=null)
            oldUser.setHeight(user.getHeight());

        if(user.getWeight()!=null)
            oldUser.setWeight(user.getWeight());

        if(user.getBio()!=null)
            oldUser.setBio(user.getBio());

        return userRepo.save(oldUser);

    }

    public void deleteUser(Long id)
    {
        userRepo.deleteById(id);
    }

}
