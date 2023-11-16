package fr.univartois.butinfo.r5a05.demo.repository;

import fr.univartois.butinfo.r5a05.demo.entity.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {

    public Character findByName();
}
