package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch;

import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.Contract;
import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model.PartnerContractsOverview;
import ch.mhaspra.insurancecase.overviewservice.application.OverviewRepository;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.AddContractToPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import ch.mhaspra.insurancecase.overviewservice.domain.commands.RemoveContractFromPartnerCmd;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class OverviewRepositoryImpl implements OverviewRepository {
    private final OverviewEsRepository esRepository;
    private final ReactiveOverviewESRepository reactiveOverviewESRepository;

    @Autowired
    public OverviewRepositoryImpl(OverviewEsRepository esRepository, ReactiveOverviewESRepository reactiveOverviewESRepository) {
        this.esRepository = esRepository;
        this.reactiveOverviewESRepository = reactiveOverviewESRepository;
    }

    @Override
    public Overview findAll(){
        Iterable<PartnerContractsOverview> all = esRepository.findAll();
        return OverviewIterableMapper.map(all);
    }

    @Override
    public Flux<Partner> findAllReactive() {
        return reactiveOverviewESRepository.findAll().map(OverviewMapper::map);
    }


    @Override
    public void add(AddContractToPartnerCmd addContractToPartnerCmd) {
        PartnerContractsOverview overview = findById(addContractToPartnerCmd);
        if(contractAlreadySaved(addContractToPartnerCmd, overview)){
            return;
        }

        Contract contract = newContractFrom(addContractToPartnerCmd);
        overview.contracts.add(contract);

        esRepository.save(overview);
    }

    private boolean contractAlreadySaved(AddContractToPartnerCmd addContractToPartnerCmd, PartnerContractsOverview overview) {
        return overview.contracts.stream().anyMatch(c -> c.contractNr.equals(addContractToPartnerCmd.contractNr()));
    }

    private PartnerContractsOverview findById(AddContractToPartnerCmd addContractToPartnerCmd) {
        Optional<PartnerContractsOverview> overviewOptional = esRepository.findById(addContractToPartnerCmd.partnerNr());
        return overviewOptional.orElseGet(() -> newOverviewFrom(addContractToPartnerCmd));
    }

    private PartnerContractsOverview newOverviewFrom(AddContractToPartnerCmd addContractToPartnerCmd) {
        var overview = new PartnerContractsOverview();
        overview.partnerNr = addContractToPartnerCmd.partnerNr();
        overview.name = addContractToPartnerCmd.name();
        overview.contracts = new ArrayList<>();
        return overview;
    }

    private Contract newContractFrom(AddContractToPartnerCmd addContractToPartnerCmd) {
        Contract contract = new Contract();
        contract.contractNr = addContractToPartnerCmd.contractNr();
        contract.title = addContractToPartnerCmd.title();
        return contract;
    }

    @Override
    public void remove(RemoveContractFromPartnerCmd removeContractFromPartnerCmd) {
        Optional<PartnerContractsOverview> overviewOptional = esRepository.findById(removeContractFromPartnerCmd.partnerNr());

        if(overviewOptional.isPresent()){
            var overview = overviewOptional.get();
            overview.contracts.removeIf(contract -> contract.contractNr.equals(removeContractFromPartnerCmd.contractNr()));

            esRepository.save(overview);
        }
    }
}
