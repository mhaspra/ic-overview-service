package ch.mhaspra.insurancecase.overviewservice.adapter.kafka;

import ch.mhaspra.insurancecase.overviewservice.adapter.kafka.serdes.Overview;
import ch.mhaspra.insurancecase.overviewservice.application.OverviewService;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.AddContractToPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.RemoveContractFromPartnerCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OverviewUpdater {
    private final OverviewService overviewService;

    @Autowired
    public OverviewUpdater(OverviewService overviewService) {
        this.overviewService = overviewService;
    }

    public void update(String key, Overview overview) {
        if(overview.active()){
            overviewService.add(new AddContractToPartnerCmd(overview.partnerNr(), overview.name(), Long.parseLong(key), overview.title()));
        } else {
            overviewService.remove(new RemoveContractFromPartnerCmd(overview.partnerNr(), Long.parseLong(key)));
        }
    }
}
