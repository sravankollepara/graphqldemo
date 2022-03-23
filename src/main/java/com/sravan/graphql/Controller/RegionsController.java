package com.sravan.graphql.Controller;

import com.sravan.graphql.db.entity.Regions;
import com.sravan.graphql.db.repository.RegionsRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.servlet.GraphQLInvocationInputFactory;
import graphql.servlet.GraphQLQueryInvoker;
import graphql.servlet.GraphQLSingleInvocationInput;
import graphql.servlet.internal.GraphQLRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegionsController {

    @Autowired
    private GraphQLInvocationInputFactory invocationInputFactory;
    @Autowired
    private GraphQLQueryInvoker queryInvoker;

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public ResponseEntity<Object> getRegions(@RequestParam String query)
    {
        GraphQLRequest request = new GraphQLRequest(query,null,null);
        GraphQLSingleInvocationInput invocationInput = invocationInputFactory.create(request);
        ExecutionResult execute = queryInvoker.query(invocationInput);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
