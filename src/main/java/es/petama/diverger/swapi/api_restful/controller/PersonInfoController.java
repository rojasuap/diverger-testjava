package es.petama.diverger.swapi.api_restful.controller;

import es.petama.diverger.swapi.api_restful.model.dto.PeopleDto;
import es.petama.diverger.swapi.api_restful.service.IPersonInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/swapi-proxy/person-info")
public class PersonInfoController {

    private final IPersonInfoService iPersonInfoService;

    public PersonInfoController(final IPersonInfoService iPersonInfoService){
        this.iPersonInfoService=iPersonInfoService;
    }

    @RequestMapping("/{id}")
    public ResponseEntity<PeopleDto> getPeople(@PathVariable Integer id){
        Optional<PeopleDto> optPeopleDto = iPersonInfoService.findPeopleId(id);
        return optPeopleDto.map(peopleDto ->
                ResponseEntity.status(HttpStatus.OK).body(peopleDto))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @RequestMapping
    public ResponseEntity<List<PeopleDto>> getAllPeople(){

        List<PeopleDto> peopleDtos =  iPersonInfoService.findAllPeaple();
        return ResponseEntity.status(HttpStatus.OK).body(peopleDtos);
    }


}
