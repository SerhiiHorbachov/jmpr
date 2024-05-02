package com.jmpr;

import com.jmpr.utils.model.Visitor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectMapperTest {
    
    @Test
    void readToObjectShouldReturnInstanceOfProvidedType() {
        ObjectMapper mapper = new ObjectMapper();
        Visitor visitor = mapper.readToObject("", Visitor.class);
        assertThat(visitor).isNotNull();
    }
}