package ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Contract(@JsonProperty("contractNr") Long contractNr,  @JsonProperty("partnerNr") String partnerNr, @JsonProperty("title") String title, @JsonProperty("active") boolean active) {
}
