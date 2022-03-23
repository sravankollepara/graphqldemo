package com.sravan.graphql.db.repository;

import com.sravan.graphql.db.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries,String> {
}
