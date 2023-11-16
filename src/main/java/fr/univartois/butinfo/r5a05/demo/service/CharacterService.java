package fr.univartois.butinfo.r5a05.demo.service;

import fr.univartois.butinfo.r5a05.demo.entity.Character;
import fr.univartois.butinfo.r5a05.demo.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

}
