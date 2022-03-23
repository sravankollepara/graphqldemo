package com.sravan.graphql.Config;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import kotlin.reflect.full.KProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQL graphQL() throws IOException {
        URL url=Resources.getResource("region.graphqls");
        String parsedString=Resources.toString(url, Charsets.UTF_8);
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(parsedString);
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring)
                .build();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
}
