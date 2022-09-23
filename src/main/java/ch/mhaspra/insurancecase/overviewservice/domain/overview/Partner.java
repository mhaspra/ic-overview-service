package ch.mhaspra.insurancecase.overviewservice.domain.overview;

import java.util.List;

public record Partner(Long partnerNr, String name, List<Contract> contracts) {
}
