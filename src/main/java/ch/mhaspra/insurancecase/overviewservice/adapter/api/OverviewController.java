package ch.mhaspra.insurancecase.overviewservice.adapter.api;

import ch.mhaspra.insurancecase.overviewservice.adapter.api.dto.PartnerDto;
import ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.OverviewMapper;
import ch.mhaspra.insurancecase.overviewservice.application.OverviewService;
import ch.mhaspra.insurancecase.overviewservice.domain.overview.Overview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class OverviewController {
    private final OverviewService overviewService;

    @Autowired
    public OverviewController(OverviewService overviewService) {
        this.overviewService = overviewService;
    }

    @GetMapping("/overview")
    public List<PartnerDto> all(){
        final Overview overview = overviewService.getOverview();
        return PartnerDtoMapper.map(overview);
    }

    @GetMapping("/overview-reactive")
    public Flux<PartnerDto> overviewReactive(){
        var overview = overviewService.getOverviewReactive();
        return overview.map(PartnerDtoMapper::map);

    }
}
