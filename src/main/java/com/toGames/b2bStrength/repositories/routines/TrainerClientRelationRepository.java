package com.toGames.b2bStrength.repositories.routines;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource
public interface TrainerClientRelationRepository extends JpaRepository<TrainerClientRelation, Long> {

    public Set<TrainerClientRelation> findByClientId(long id);

    public Set<TrainerClientRelation> findByTrainerIdAndStatusId(long trainerId, long statusId);
    public Set<TrainerClientRelation> findByStatusId(long id);
}
