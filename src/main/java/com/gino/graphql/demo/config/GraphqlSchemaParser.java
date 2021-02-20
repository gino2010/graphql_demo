package com.gino.graphql.demo.config;

import graphql.kickstart.tools.SchemaParserDictionary;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import io.github.kobylynskyi.bikeshop.graphql.model.DepositOrderTO;
import io.github.kobylynskyi.bikeshop.graphql.model.NormalOrderTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class GraphqlSchemaParser {
    @Bean
    public SchemaParserDictionary getSchemaParser() {
        SchemaParserDictionary dictionary = new SchemaParserDictionary();
        dictionary.add(new HashMap<>() {
            {
                put("DepositOrder", DepositOrderTO.class);
                put("NormalOrder", NormalOrderTO.class);
            }
        });
        return dictionary;
    }

    @Bean
    public GraphQLScalarType extendedScalarsDateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType extendedScalarsBigDecimal() {
        return ExtendedScalars.GraphQLBigDecimal;
    }
}
