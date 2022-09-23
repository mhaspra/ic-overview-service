package ch.mhaspra.insurancecase.overviewservice.domain.commands;

public record RemoveContractFromPartnerCmd(Long partnerNr, Long contractNr) {
}
