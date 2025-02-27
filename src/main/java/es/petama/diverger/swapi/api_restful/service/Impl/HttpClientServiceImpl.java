package es.petama.diverger.swapi.api_restful.service.Impl;

import es.petama.diverger.swapi.api_restful.exceptions.ApiErrorException;
import es.petama.diverger.swapi.api_restful.service.HttpClientService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class HttpClientServiceImpl implements HttpClientService {

    private RestTemplate restTemplate;

    public HttpClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T httpGet(String url, Map<String, String> params, Class<T> responseType) {

        String finalUrl = buildFinalUrl(url, params);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.GET, httpEntity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value()) {
            String errorMessage = String.format("Error consumiento del API [ {} - {} ], codigo de respuesta es: {}",
                    HttpMethod.GET, finalUrl, response.getStatusCode().value());
            throw new ApiErrorException(errorMessage);
        }

        return response.getBody();
    }

    private static String buildFinalUrl(String url, Map<String, String> params) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url); // ?nombre=Santiago

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) { // "nombre" : "Santiago", "apellido" : "Perez"
                uriBuilder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        String finalUrl = uriBuilder.build().toUriString();
        return finalUrl;
    }

}
