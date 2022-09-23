package ch.mhaspra.insurancecase.overviewservice.adapter.kafka;

import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.*;
import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Partner;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.BiFunction;
import java.util.function.Consumer;


@Configuration
public class KafkaStreamsHandler {

    @Bean
    public BiFunction<KTable<String, Partner>, KTable<String, Contract>, KStream<String, Overview>> joinPartnerAndContract() {
        return (partner, contract) -> contract
                .join(partner,
                        new PartnerNrExtractor(),
                        new OverviewJoiner(),
                        Materialized.<String, Overview, KeyValueStore<Bytes, byte[]>>as("partner-contract-join-store").withValueSerde(new OverviewSerde()))
                .toStream();
    }

    @Bean
    public Consumer<KStream<String, Overview>> consumeOverview(OverviewUpdater overviewUpdater) {
        return overviews -> overviews.foreach(overviewUpdater::update);
    }
}
