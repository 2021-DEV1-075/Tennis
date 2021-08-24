package be.bnpparibasfortis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.bnpparibasfortis.model.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

}
