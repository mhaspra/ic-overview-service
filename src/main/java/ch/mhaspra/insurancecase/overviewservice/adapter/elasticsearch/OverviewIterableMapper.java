package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch;

import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.PartnerContractsOverview;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;

import java.util.stream.StreamSupport;

public class OverviewIterableMapper {
    public static Overview map(Iterable<PartnerContractsOverview> all){
        return new Overview(StreamSupport.stream(all.spliterator(), false).map(OverviewMapper::map).toList());
    }
}
