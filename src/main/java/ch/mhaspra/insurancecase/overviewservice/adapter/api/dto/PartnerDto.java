package ch.mhaspra.insurancecase.overviewservice.adapter.api.dto;

import java.util.List;

public record PartnerDto(Long partnerNr, String name, List<ContractDto> contracts) {
}
