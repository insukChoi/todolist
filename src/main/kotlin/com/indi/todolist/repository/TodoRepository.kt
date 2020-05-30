package com.indi.todolist.repository

import com.indi.todolist.support.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface TodoRepository : JpaRepository<Todo, Long>