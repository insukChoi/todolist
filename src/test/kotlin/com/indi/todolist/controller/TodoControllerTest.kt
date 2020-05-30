package com.indi.todolist.controller

import com.indi.todolist.SpringTestContextSupport
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get

internal class TodoControllerTest
    : SpringTestContextSupport() {

    private val baseUrl = "/todo"

    @Test
    @Sql("/data-test.sql")
    internal fun `todo controller 테스트` () {
        // when & then
        mockMvc.get(baseUrl) {
            content = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
            jsonPath("$._links.self") { exists() }
            jsonPath("$._embedded.todos.length()") { value(3) }
        }.andDo { print() }
    }
}