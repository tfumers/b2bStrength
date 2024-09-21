package com.toGames.b2bStrength.services.trainings.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.toGames.b2bStrength.dtos.trainings.*;
import com.toGames.b2bStrength.dtos.utils.TrainingSearchParamsDTO;
import com.toGames.b2bStrength.dtos.utils.ValidatedTrainingSearchParamsDTO;
import com.toGames.b2bStrength.models.trainings.Training;
import com.toGames.b2bStrength.models.trainings.TrainingCategory;
import com.toGames.b2bStrength.models.trainings.TrainingCategoryRelation;
import com.toGames.b2bStrength.models.trainings.TrainingDifficulty;
import com.toGames.b2bStrength.repositories.trainings.TrainingCategoryRelationRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingCategoryRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingDifficultyRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingRepository;
import com.toGames.b2bStrength.services.trainings.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.toGames.b2bStrength.utils.Common.setCurrentTime;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainingCategoryRepository trainingCategoryRepository;

    @Autowired
    TrainingDifficultyRepository trainingDifficultyRepository;

    @Autowired
    TrainingCategoryRelationRepository trainingCategoryRelationRepository;

    //Implementar lógica
    @Override
    public List<DetailedTrainingOutDTO> getTrainingsByParams(TrainingSearchParamsDTO paramsDTO) {
//        ValidatedTrainingSearchParamsDTO validParams = validateTrainingSearchParameters(paramsDTO);

        List<DetailedTrainingOutDTO> trainings = new ArrayList<>();

        if(paramsDTO.getName().length()>0){
            trainings = trainingRepository.findByNameContainsIgnoreCaseOrderById(paramsDTO.getName()).stream().map(DetailedTrainingOutDTO::new).collect(Collectors.toList());
            return trainings;
        }

        if(paramsDTO.getDesc().length()>0){
            trainings = trainingRepository.findByDescriptionContainsIgnoreCaseOrderById(paramsDTO.getDesc()).stream().map(DetailedTrainingOutDTO::new).collect(Collectors.toList());
            return trainings;
        }

        if(paramsDTO.getCategory().length()>0){
            TrainingCategory tc = trainingCategoryRepository.findByNameIgnoreCase(paramsDTO.getCategory()).orElse(null);

            if(tc!=null){
                trainings = trainingRepository.findByTrainingCategoryRelationsCategoryIdEqualsOrderById(tc.getId()).stream().map(DetailedTrainingOutDTO::new).collect(Collectors.toList());
                return trainings;
            }
        }

        if(paramsDTO.getDifficulty().length()>0){
            TrainingDifficulty td = trainingDifficultyRepository.findByNameIgnoreCase(paramsDTO.getDifficulty()).orElse(null);

            if(td!=null){
                trainings = trainingRepository.findByDifficultyIdEqualsOrderById(td.getId()).stream().map(DetailedTrainingOutDTO::new).collect(Collectors.toList());
                return trainings;
            }
        }

        return trainings;
    }

    @Override
    public Optional<DetailedTrainingOutDTO> getTrainingById(Long id) {
        return trainingRepository.findById(id).map(DetailedTrainingOutDTO::new);
    }

    @Override
    public List<DetailedTrainingOutDTO> findByNameContainsOrderById(String search){
        return trainingRepository.findByNameContainsIgnoreCaseOrderById(search).stream().map(DetailedTrainingOutDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<DetailedTrainingOutDTO> getTrainingsByCategory(String category){
        return new ArrayList<>();
    }

    @Override
    public Optional<DetailedTrainingCategoryDTO> createNewCategory(NewCategoryDTO newCategoryDTO) {

        //Validation
        TrainingCategory trainingCategory = new TrainingCategory(newCategoryDTO.getName(), newCategoryDTO.getDescription());
        trainingCategory = trainingCategoryRepository.save(trainingCategory);

        return Optional.of(new DetailedTrainingCategoryDTO(trainingCategory));
    }

    @Override
    public Optional<DetailedTrainingDifficultyDTO> createNewDifficulty(NewDifficultyDTO newDifficultyDTO) {

        //Validation
        TrainingDifficulty trainingDifficulty = new TrainingDifficulty(newDifficultyDTO.getName(), newDifficultyDTO.getDescription());
        trainingDifficulty = trainingDifficultyRepository.save(trainingDifficulty);

        return Optional.of(new DetailedTrainingDifficultyDTO(trainingDifficulty));
    }

    @Override
    public Optional<DetailedTrainingOutDTO> createNewTraining(NewTrainingDTO newTrainingDTO) {

        if(newTrainingDTO.getId()!=0){
            throw new RuntimeException("Entrenamiento ya existe");
        }
        else{
            Training training = new Training(setCurrentTime(),setCurrentTime(),true, newTrainingDTO.getName(), newTrainingDTO.getDescription(), newTrainingDTO.getVideoUrl(), newTrainingDTO.getImageUrl(), newTrainingDTO.getEstTimePerRep(), newTrainingDTO.getEstCaloriesPerRep());

            TrainingDifficulty trainingDifficulty = trainingDifficultyRepository.findByNameIgnoreCase(newTrainingDTO.getDifficulty()).orElse(null);

            if(trainingDifficulty!=null){
                training.setDifficulty(trainingDifficulty);
            }

            training = trainingRepository.save(training);

            int noCatCounter = 0;
            for (String cat:
                    newTrainingDTO.getCategories()) {


                TrainingCategory trainingCategory = trainingCategoryRepository.findByNameIgnoreCase(cat).orElse(null);

                if(trainingCategory!=null){
                    trainingCategoryRelationRepository.save(new TrainingCategoryRelation(training, trainingCategory, setCurrentTime(),setCurrentTime()));
                }

                else if(noCatCounter == 0){
                    noCatCounter++;
                    TrainingCategory tc = trainingCategoryRepository.findById(1L).orElse(null);

                    trainingCategoryRelationRepository.save(new TrainingCategoryRelation(training, tc, setCurrentTime(),setCurrentTime()));
                }
            }

            return Optional.of(new DetailedTrainingOutDTO(training));
        }
    }

    @Override
    public Optional<DetailedTrainingOutDTO> updateTraining(JsonPatch newTrainingPatch, Long id) {
        Training training = trainingRepository.findById(id).orElse(null);
        if(training==null){
            return Optional.empty();
        }

        try {
            training = applyPatchToTraining(newTrainingPatch, training);
        }
        catch (JsonProcessingException e){
            return Optional.empty();
//            throw new RuntimeException(e);
        }
        catch (JsonPatchException e) {
            return Optional.empty();
//            throw new RuntimeException(e);
        }
        trainingRepository.save(training);


        return Optional.of(new DetailedTrainingOutDTO(training));
    }

    @Override
    public String deleteTrainingById(Long id) {
        Training training = trainingRepository.findById(id).orElse(null);
        if(training==null)
        {
            return "invalid id";
        }

        training.setEnabled(false);
        trainingRepository.save(training);
        return "Ok";
    }

    @Override
    public String deleteCategoryById(Long id) {
        TrainingCategory trainingCategory = trainingCategoryRepository.findById(id).orElse(null);
        if(trainingCategory==null){
            return "invalid id";
        }

        if(trainingCategory.getTrainingCategoryRelations().size() >0){
            return "is still in use";
        }

        trainingCategoryRepository.delete(trainingCategory);;
        return "Ok";
    }

    @Override
    public String deleteDifficultyById(Long id) {
        TrainingDifficulty trainingDifficulty = trainingDifficultyRepository.findById(id).orElse(null);
        if(trainingDifficulty==null){
            return "invalid id";
        }

        if(trainingDifficulty.getTrainings().size() >0){
            return "is still in use";
        }

        trainingDifficultyRepository.delete(trainingDifficulty);;
        return "Ok";
    }

    @Override
    public List<DetailedTrainingOutDTO> getTrainingsById(TrainingsInDTO trainingsInDTO) {
        List<DetailedTrainingOutDTO> trainingDTOList = new ArrayList<>();

        for (Long trainingId:
             trainingsInDTO.getTrainingIds()) {
            getTrainingById(trainingId).ifPresent(trainingDTOList::add);

        }


        return trainingDTOList;
    }

    private ValidatedTrainingSearchParamsDTO validateTrainingSearchParameters(TrainingSearchParamsDTO paramsDTO){

        ValidatedTrainingSearchParamsDTO validSearchParams = new ValidatedTrainingSearchParamsDTO();

        validSearchParams.setCatId(validateLongParam(paramsDTO.getCategory(), trainingCategoryRepository));
        validSearchParams.setDifId(validateLongParam(paramsDTO.getDifficulty(), trainingDifficultyRepository));

        validSearchParams.setName(paramsDTO.getName());
        validSearchParams.setDesc(paramsDTO.getDesc());

        return validSearchParams;
    }

    private Long validateLongParam(String param, JpaRepository repository){
        Long validLong;
        try{
            validLong = Long.parseLong(param);

        }
        catch (NumberFormatException e){
            validLong = 0L;
        }

        if(validLong > repository.count()){
            validLong = 0L;
        }

        return validLong;
    }

    private Training applyPatchToTraining(JsonPatch patch, Training targetTraining) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetTraining, JsonNode.class));
        return objectMapper.treeToValue(patched, Training.class);
    }
}
