package com.indi.todolist.service

import com.indi.todolist.repository.TodoRepository
import com.indi.todolist.support.entity.Todo
import com.indi.todolist.web.param.TodoParam
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import com.indi.todolist.web.dto.Todo as TodoDto

@Transactional
@Service
class TodoService(
        private val todoRepository: TodoRepository,
        private val modelMapper: ModelMapper
) {

    companion object {
      const val OWNER = "indi"
    }

    fun getListAll(
            pageable: Pageable
    ): Page<TodoDto> {
        return todoRepository.findAll(pageable).map(::TodoDto)
    }

    fun addTodo(param: TodoParam): Todo {
        return todoRepository.save(
          Todo.create(param, OWNER)
        )
    }

    fun deleteAll() {
        return todoRepository.deleteAll()
    }

    fun deleteTodo(content: String) {
        return todoRepository.deleteByContent(content)
    }
}
