package com.workoutTracker.workout.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "workout_table")
public class Workout {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;


   //totalTime in seconds
   @NonNull
   private Long totalTime=0L;

   //total Volume of the workout
   @NonNull
   private Long totalVolume= 0L;

   @NonNull
   private String title;
   private String workout_desc="";

   private String imageUrl="";

   @NonNull
   @CreationTimestamp
   private Date createdAt;

   private Date scheduleAt;

   private Boolean isCompleted=false;


   @NonNull
   @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private List<Exercise> exerciseList =new ArrayList<>();

   @ManyToOne
   @JoinColumn(name = "user_id")
   @JsonIgnore
   private User user;
}
