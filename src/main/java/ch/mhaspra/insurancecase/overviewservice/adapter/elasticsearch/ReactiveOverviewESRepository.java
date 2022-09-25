package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch;

import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.PartnerContractsOverview;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveOverviewESRepository extends ReactiveCrudRepository<PartnerContractsOverview, Long> {
}
