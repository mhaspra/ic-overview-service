package ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Overview(@JsonProperty("name") String name, @JsonProperty("partnerNr") Long partnerNr, @JsonProperty("title") String title, @JsonProperty("active") boolean active) {
}
