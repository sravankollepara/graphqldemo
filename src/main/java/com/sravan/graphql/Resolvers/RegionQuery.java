package com.sravan.graphql.Resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sravan.graphql.db.entity.Countries;
import com.sravan.graphql.db.entity.Regions;
import com.sravan.graphql.db.repository.CountriesRepository;
import com.sravan.graphql.db.repository.RegionsRepository;
import com.sravan.graphql.filters.Filter;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
@AllArgsConstructor
public class RegionQuery implements GraphQLQueryResolver {

    RegionsRepository regionsRepository;
    CountriesRepository countriesRepository;
    EntityManagerFactory entityManagerFactory;

    public Regions test(Long Id)
    {
       return regionsRepository.findById(Id).orElse(null);
    }

    public List<Regions> test1(Filter filter, DataFetchingEnvironment dfe)
    {
        return regionsRepository.getCustomRegionsByIds(filter.getRegionIds());
    }
    public Countries test2(String Id, DataFetchingEnvironment dataFetchingEnvironment)
    {
        Countries countries = countriesRepository.findById(Id).orElse(new Countries());
        return countries;
    }

}
