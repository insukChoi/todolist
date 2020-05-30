package com.indi.todolist.controller

import com.indi.todolist.service.TodoService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.MediaTypes
import org.springframework.hateoas.PagedModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.indi.todolist.web.dto.Todo as TodoDto

@RestController
@RequestMapping("/todo")
class TodoController(
        private val todoService: TodoService
) {

    @GetMapping(produces = ["application/json;charset=utf-8"])
    fun getList(
            @PageableDefault(
                    sort = ["id"],
                    direction = Sort.Direction.DESC
            ) pageable: Pageable,
            pagedResourcesAssembler: PagedResourcesAssembler<TodoDto>
    ): PagedModel<EntityModel<TodoDto>> =
            pagedResourcesAssembler.toModel(
                    todoService.getListAll(pageable)
            )
}