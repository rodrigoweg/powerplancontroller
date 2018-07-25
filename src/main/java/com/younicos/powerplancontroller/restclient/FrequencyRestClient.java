package com.younicos.powerplancontroller.restclient;

import com.younicos.powerplancontroller.dto.Frequency;
import com.younicos.powerplancontroller.exception.UnavailableFrequencyServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class FrequencyRestClient {
    private static final String URL_FRECUENCY = "http://freq-gen-online-frequency-generator.7e14.starter-us-west-2.openshiftapps.com/frequency";

    static Logger log = LoggerFactory.getLogger(FrequencyRestClient.class);

    Frequency read() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Send request with GET method and default Headers.
            ResponseEntity<Frequency> response = restTemplate.getForEntity(URL_FRECUENCY, Frequency.class);

            if(response.getStatusCode().equals(HttpStatus.REQUEST_TIMEOUT)){
                throw new UnavailableFrequencyServiceException();
            }
            log.debug(response.getBody().toString());
            return response.getBody();
        }catch (RestClientException e){
            e.printStackTrace();
        }
        return null;
    }
}
