package com.indi.todolist.support.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "todo")
class Todo : BaseEntity(){

    @Column(name = "content")
    var content: String ?= null
        private set

    @Column(name = "is_star")
    var isStar: Boolean = false
        private set

    @Column(name = "is_done")
    var isDone: Boolean = false
        private set
}