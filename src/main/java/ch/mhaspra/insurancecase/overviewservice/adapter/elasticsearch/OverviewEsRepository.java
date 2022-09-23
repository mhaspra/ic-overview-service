package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch;

import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.PartnerContractsOverview;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OverviewEsRepository extends ElasticsearchRepository<PartnerContractsOverview, Long> {
}
