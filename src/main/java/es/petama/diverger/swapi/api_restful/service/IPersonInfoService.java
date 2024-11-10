package es.petama.diverger.swapi.api_restful.service;

import es.petama.diverger.swapi.api_restful.model.dto.PeopleDto;

import java.util.List;
import java.util.Optional;

public interface IPersonInfoService {
    Optional<PeopleDto> findPeopleId(Integer id);
    List<PeopleDto> findAllPeaple();
}
