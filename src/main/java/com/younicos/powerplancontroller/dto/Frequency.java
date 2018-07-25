package com.younicos.powerplancontroller.dto;

import lombok.ToString;

@ToString
public class Frequency {
    private FrequencyReading frequencyReading;
    private boolean isValid;

    public FrequencyReading getFrequencyReading() {
        return frequencyReading;
    }

    public void setFrequencyReading(FrequencyReading frequencyReading) {
        this.frequencyReading = frequencyReading;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
