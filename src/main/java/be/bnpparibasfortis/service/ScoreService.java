package be.bnpparibasfortis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Score;
import be.bnpparibasfortis.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	public Score update(Long id, Integer points) throws BusinessException {
		Score score = getById(id);
		score.setPoints(points);
		return scoreRepository.save(score);
	}

	public Score getById(Long id) throws BusinessException {
		return scoreRepository.findById(id)
				.orElseThrow(() -> new BusinessException(MessageSource.get().message(MessageEnum.ERR04, id)));
	}

}
