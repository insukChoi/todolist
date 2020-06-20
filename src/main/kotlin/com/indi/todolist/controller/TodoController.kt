package com.indi.todolist.controller

import com.indi.todolist.service.TodoService
import com.indi.todolist.support.entity.Todo
import com.indi.todolist.web.param.TodoParam
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger
import com.indi.todolist.web.dto.Todo as TodoDto

@Api("TODO API")
@RestController
@RequestMapping("/todo")
@CrossOrigin
class TodoController(
  private val todoService: TodoService
) {

    @ApiOperation("TODO LIST 가져오기")
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

    @ApiOperation("TODO LIST 추가")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addTodo(
        @RequestBody param: TodoParam
    ): Todo {
        return todoService.addTodo(param)
    }

    @ApiOperation("TODO LIST 삭제")
    @DeleteMapping("/delete/{content}")
    fun deleteTodo(
        @PathVariable content: String
    ) {
        return todoService.deleteTodo(content)
    }

    @ApiOperation("TODO LIST 전체삭제")
    @DeleteMapping("/delete/all")
    fun deleteAllTodo() {
        return todoService.deleteAll()
    }
}
