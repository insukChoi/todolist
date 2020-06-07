package com.indi.todolist.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig {
    @Bean
    fun modelMapper() : ModelMapper {
        return ModelMapper()
    }
}
