package com.indi.todolist.service

import com.indi.todolist.repository.TodoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import com.indi.todolist.web.dto.Todo as TodoDto

@Service
class TodoService(
        private val todoRepository: TodoRepository
) {

    @Transactional
    fun getListAll(
            pageable: Pageable
    ): Page<TodoDto> {
        return todoRepository.findAll(pageable).map(::TodoDto)
    }
}