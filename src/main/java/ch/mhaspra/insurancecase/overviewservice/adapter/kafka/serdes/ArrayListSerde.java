package ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes;

import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.ArrayList;

public class ArrayListSerde extends JsonSerde<ArrayList<String>> {
}
