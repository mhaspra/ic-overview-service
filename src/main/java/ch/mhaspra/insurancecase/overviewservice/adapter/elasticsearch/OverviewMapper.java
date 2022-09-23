package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch;

import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.PartnerContractsOverview;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Contract;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Partner;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OverviewMapper {
    public static Overview map(Iterable<PartnerContractsOverview> all){
        return new Overview(StreamSupport.stream(all.spliterator(), false).map(OverviewMapper::map).toList());
    }

    private static Partner map(PartnerContractsOverview partnerContractsOverview){
        return new Partner(
                partnerContractsOverview.partnerNr,
                partnerContractsOverview.name,
                map(partnerContractsOverview.contracts));
    }

    private static List<Contract> map(List<ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.Contract> contracts) {
        return contracts.stream().map(OverviewMapper::map).toList();
    }

    private static Contract map(ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.Contract contract) {
        return new Contract(contract.contractNr, contract.title);
    }
}
