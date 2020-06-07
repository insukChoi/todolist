package com.indi.todolist.support.entity

import com.indi.todolist.web.param.TodoParam
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.PostPersist
import javax.persistence.Table

@Entity
@Table(name = "todo")
class Todo(
  @Column(name = "content")
  var content: String,

  @Column(name = "is_star")
  var isStar: Boolean,

  @Column(name = "is_done")
  var isDone: Boolean = false
) : BaseEntity(){

    @PostPersist
    fun postPersist() {
        val now = LocalDateTime.now()
        this.createdAt = now
        this.updatedAt = now
    }

    companion object {
        fun create(param: TodoParam, byWho: String) : Todo {
            val entity = Todo(
                content = param.todoItem,
                isStar = false,
                isDone = false
            )
            entity.createdBy = byWho
            entity.updatedBy = byWho
            return entity
        }
    }
}
