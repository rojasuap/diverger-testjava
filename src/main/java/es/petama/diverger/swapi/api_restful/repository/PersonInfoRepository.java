package es.petama.diverger.swapi.api_restful.repository;

import es.petama.diverger.swapi.api_restful.Entity.PersonInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInfoRepository extends JpaRepository<PersonInfoEntity,Long> {
}
