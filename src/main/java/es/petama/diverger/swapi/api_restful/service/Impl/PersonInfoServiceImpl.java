package es.petama.diverger.swapi.api_restful.service.Impl;

import es.petama.diverger.swapi.api_restful.model.dto.PeopleDto;
import es.petama.diverger.swapi.api_restful.service.IPersonInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonInfoServiceImpl implements IPersonInfoService {

    private final  RestTemplate restTemplate;

    public PersonInfoServiceImpl(final RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public Optional<PeopleDto> findPeopleId(Integer id) {
        ResponseEntity<PeopleDto> responseEntity = restTemplate.getForEntity("https://swapi.dev/api/people/"+ id.toString(), PeopleDto.class);
        return Optional.ofNullable(responseEntity.getBody());
    }

    @Override
    public List<PeopleDto> findAllPeaple() {
        ResponseEntity<PeopleDto> responseEntity = restTemplate.getForEntity("https://swapi.dev/api/people", PeopleDto.class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }
}

