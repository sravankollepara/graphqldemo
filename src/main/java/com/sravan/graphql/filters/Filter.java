package com.sravan.graphql.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Filter {
    List<Long> regionIds;
}
