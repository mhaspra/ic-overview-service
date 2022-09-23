package ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.kafka.support.serializer.JsonSerde;

public record Partner(@JsonProperty("partnerNr") Long partnerNr, @JsonProperty("name") String name, @JsonProperty("active") boolean active) {
}
