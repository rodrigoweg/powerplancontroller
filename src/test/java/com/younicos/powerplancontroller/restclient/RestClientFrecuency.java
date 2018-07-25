package com.younicos.powerplancontroller.restclient;

import com.younicos.powerplancontroller.dto.Frequency;
import com.younicos.powerplancontroller.exception.UnavailableFrequencyServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RestClientFrecuency {

    FrequencyRestClient frecuencyRestClient;

    @Before
    public void setup() {
        frecuencyRestClient = new FrequencyRestClient();
    }

    @Test
    public void read(){
        try{
            Frequency frequency = frecuencyRestClient.read();
            assert(frequency!=null);
            System.out.println("Frecuency: "+frequency.toString());
        }catch (UnavailableFrequencyServiceException e){
            // this is correct behaviour test -> should past
            e.printStackTrace();
        }

    }
}
