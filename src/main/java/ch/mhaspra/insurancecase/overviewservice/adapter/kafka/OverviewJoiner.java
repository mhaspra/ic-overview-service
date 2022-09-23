package ch.mhaspra.insurancecase.overviewservice.adapter.kafka;

import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Contract;
import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Overview;
import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Partner;
import org.apache.kafka.streams.kstream.ValueJoiner;

public class OverviewJoiner implements ValueJoiner<Contract, Partner, Overview> {

    @Override
    public Overview apply(Contract contract, Partner partner) {
        return new Overview(partner.name(), partner.partnerNr(), contract.title(), contract.active());
    }
}
