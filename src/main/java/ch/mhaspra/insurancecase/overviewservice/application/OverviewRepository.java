package ch.mhaspra.insurancecase.overviewservice.application;

import ch.mhaspra.insurancecase.overviewservice.domain.commands.AddContractToPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.RemoveContractFromPartnerCmd;

public interface OverviewRepository {

    Overview findAll();

    void add(AddContractToPartnerCmd addContractToPartnerCmd);

    void remove(RemoveContractFromPartnerCmd removeContractFromPartnerCmd);
}
