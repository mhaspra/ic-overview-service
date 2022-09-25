package ch.mhaspra.insurancecase.overviewservice.application;

import ch.mhaspra.insurancecase.overviewservice.domain.commands.AddContractToPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.RemoveContractFromPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Partner;
import reactor.core.publisher.Flux;

public interface OverviewRepository {

    Overview findAll();

    Flux<Partner> findAllReactive();

    void add(AddContractToPartnerCmd addContractToPartnerCmd);

    void remove(RemoveContractFromPartnerCmd removeContractFromPartnerCmd);
}
