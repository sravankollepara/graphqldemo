package com.sravan.graphql.Resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sravan.graphql.db.entity.Regions;
import com.sravan.graphql.db.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionQuery implements GraphQLQueryResolver {
    @Autowired
    RegionsRepository regionsRepository;
    public Regions test(Integer Id)
    {
       return regionsRepository.findById(Id).orElse(null);
    }
}
