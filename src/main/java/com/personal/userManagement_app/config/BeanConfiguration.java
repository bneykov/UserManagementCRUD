package com.personal.userManagement_app.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter((Converter<String, LocalDate>) mappingContext -> LocalDate
                .parse(mappingContext.getSource(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return modelMapper;
    }
}
