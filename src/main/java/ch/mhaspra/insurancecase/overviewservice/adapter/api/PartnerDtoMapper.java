package ch.mhaspra.insurancecase.overviewservice.adapter.api;


import ch.mhaspra.insurancecase.overviewservice.adapter.api.dto.ContractDto;
import ch.mhaspra.insurancecase.overviewservice.adapter.api.dto.PartnerDto;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Contract;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Partner;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;

import java.util.List;

public class PartnerDtoMapper {
    public static List<PartnerDto> map(Overview overview) {
        return overview.partners().stream().map(PartnerDtoMapper::map).toList();
    }

    public static PartnerDto map(Partner partner){
        return new PartnerDto(partner.partnerNr(), partner.name(), map(partner.contracts()));
    }

    private static List<ContractDto> map(List<Contract> contracts){
        return contracts.stream().map(PartnerDtoMapper::map).toList();
    }

    private static ContractDto map(Contract contract) {
        return new ContractDto(contract.contractNr(), contract.title());
    }
}
