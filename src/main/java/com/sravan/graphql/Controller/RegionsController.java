package com.sravan.graphql.Controller;

import com.sravan.graphql.db.entity.Regions;
import com.sravan.graphql.db.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegionsController {

    @Autowired
    private RegionsRepository regionsRepository;

    @GetMapping("/test")
    public Regions getRegions(Integer regionID)
    {
        Regions regions;
        regions=regionsRepository.findById(regionID).orElse(null);
        return regions;
    }
}
