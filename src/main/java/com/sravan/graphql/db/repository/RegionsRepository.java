package com.sravan.graphql.db.repository;

import com.sravan.graphql.db.entity.Regions;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsRepository extends JpaRepository<Regions,Integer> {
}
