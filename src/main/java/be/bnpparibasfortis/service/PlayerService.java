package be.bnpparibasfortis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.bnpparibasfortis.config.MessageEnum;
import be.bnpparibasfortis.config.MessageSource;
import be.bnpparibasfortis.exception.BusinessException;
import be.bnpparibasfortis.model.Player;
import be.bnpparibasfortis.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player save(String playerName) throws BusinessException {
		return playerRepository.save(new Player(playerName));
	}

	public Player getById(Long id) throws BusinessException {
		return playerRepository.findById(id)
				.orElseThrow(() -> new BusinessException(MessageSource.get().message(MessageEnum.ERR01, id)));
	}

}
