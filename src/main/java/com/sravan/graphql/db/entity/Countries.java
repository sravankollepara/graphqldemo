package com.sravan.graphql.db.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "COUNTRIES")
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Countries implements Serializable {
    @Id
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    private Regions region;
}
