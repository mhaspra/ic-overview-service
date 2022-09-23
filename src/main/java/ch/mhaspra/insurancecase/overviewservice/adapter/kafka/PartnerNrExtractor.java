package ch.mhaspra.insurancecase.overviewservice.adapter.kafka;

import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Contract;
import org.apache.kafka.streams.kstream.KeyValueMapper;

import java.util.function.Function;

public class PartnerNrExtractor implements Function<Contract, String> {
    @Override
    public String apply(Contract contract) {
        return contract.partnerNr();
    }
}
