package com.toGames.b2bStrength;

import com.toGames.b2bStrength.repositories.trainings.TrainingCategoryRelationRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingCategoryRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingDifficultyRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class B2bStrengthApplication {
	public static void main(String[] args) {
		SpringApplication.run(B2bStrengthApplication.class, args);
	}




	@Bean
	public CommandLineRunner initData(TrainingRepository trainingRepository,
									  TrainingDifficultyRepository trainingDifficultyRepository,
									  TrainingCategoryRepository trainingCategoryRepository,
									  TrainingCategoryRelationRepository trainingCategoryRelationRepository
									  ){
		return (args) ->{



		};
	}
}
