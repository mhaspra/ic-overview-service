package ch.mhaspra.insurancecase.overviewservice.domain.commands;

public record AddContractToPartnerCmd(Long partnerNr, String name, Long contractNr, String title) {
}
