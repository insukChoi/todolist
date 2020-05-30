package com.indi.todolist

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.*
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@SpringJUnitConfig
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestInstance(PER_CLASS)
@TestConstructor(autowireMode = ALL)
class SpringTestContextSupport {
    @Autowired
    protected lateinit var mockMvc: MockMvc
}