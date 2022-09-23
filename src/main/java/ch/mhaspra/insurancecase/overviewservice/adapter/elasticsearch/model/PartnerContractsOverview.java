package ch.mhaspra.insurancecase.overviewservice.adapter.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "partner_contracts_overview")
public class PartnerContractsOverview {
    @Id
    public Long partnerNr;

    public String name;

    @Field(type = FieldType.Nested, includeInParent = true)
    public List<Contract> contracts;
}
