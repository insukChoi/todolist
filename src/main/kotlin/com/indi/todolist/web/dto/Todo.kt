package com.indi.todolist.web.dto

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.hateoas.RepresentationModel
import java.time.LocalDateTime
import com.indi.todolist.support.entity.Todo as TodoEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
class Todo constructor(entity: TodoEntity): RepresentationModel<Todo>(){
    val id: Long = entity.id!!
    val content = entity.content
    val isStar: Boolean = entity.isStar
    val isDone: Boolean = entity.isDone
    val createdAt: LocalDateTime = entity.createdAt
    val createdBy: String = entity.createdBy
    val updatedAt: LocalDateTime = entity.updatedAt
    val updatedBy: String = entity.updatedBy
}
