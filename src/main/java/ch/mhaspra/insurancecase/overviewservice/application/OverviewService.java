package ch.mhaspra.insurancecase.overviewservice.application;


import ch.mhaspra.insurancecase.overviewservice.domain.commands.AddContractToPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.RemoveContractFromPartnerCmd;
import org.springframework.stereotype.Component;

@Component
public class OverviewService {
    private final OverviewRepository overviewRepository;

    public OverviewService(OverviewRepository overviewRepository) {
        this.overviewRepository = overviewRepository;
    }

    public Overview getOverview(){
        return overviewRepository.findAll();
    }

    public void add(AddContractToPartnerCmd addContractToPartnerCmd) {
        overviewRepository.add(addContractToPartnerCmd);
    }

    public void remove(RemoveContractFromPartnerCmd removeContractFromPartnerCmd) {
        overviewRepository.remove(removeContractFromPartnerCmd);
    }
}
