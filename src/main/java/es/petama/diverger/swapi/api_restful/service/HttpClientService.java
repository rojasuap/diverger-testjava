package es.petama.diverger.swapi.api_restful.service;

import java.util.Map;

public interface HttpClientService {

    <T> T httpGet(String url, Map<String, String> params, Class<T> responseType);
}
