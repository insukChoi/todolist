package com.indi.todolist.repository

import com.indi.todolist.support.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {
  fun deleteByContent(content: String)
}
