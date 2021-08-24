package be.bnpparibasfortis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.bnpparibasfortis.model.Score;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

}
