package com.sravan.graphql.db.repository;

import com.sravan.graphql.db.entity.Regions;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RegionsRepository extends JpaRepository<Regions,Long> {

    @Query(value="Select * from REGIONS where REGION_ID in ?1 ", nativeQuery = true)
    public List<Regions> getCustomRegionsByIds(List<Long> Ids);

}
