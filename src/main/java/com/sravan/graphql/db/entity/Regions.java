package com.sravan.graphql.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Regions {

    @Id
    @Column(name="REGION_ID", nullable = false)
    private Integer regionid;
    @Column(name="REGION_NAME", nullable = false)
    private String regionName;

    public Regions() {
    }

    public Regions(Integer regionid, String regionName) {
        this.regionid = regionid;
        this.regionName = regionName;
    }

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
