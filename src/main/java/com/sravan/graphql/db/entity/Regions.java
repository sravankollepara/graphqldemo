package com.sravan.graphql.db.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter@Setter @ToString
@Table(name="REGIONS")
public class Regions implements Serializable {

    @Id
    @Column(name="REGION_ID", nullable = false)
    private Long regionid;
    @Column(name="REGION_NAME", nullable = false)
    private String regionName;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "REGION_ID",referencedColumnName = "REGION_ID")
    private Set<Countries> countries;
}
