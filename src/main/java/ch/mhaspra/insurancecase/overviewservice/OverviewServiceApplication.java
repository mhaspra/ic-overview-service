package ch.mhaspra.insurancecase.overviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication
@EnableReactiveElasticsearchRepositories
public class OverviewServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(OverviewServiceApplication.class, args);
    }
}
