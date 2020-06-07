package com.indi.todolist.support.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null

    @CreatedDate
    lateinit var createdAt: LocalDateTime
        protected set

    @CreatedBy
    var createdBy: String = "system"

    @LastModifiedDate
    lateinit var updatedAt: LocalDateTime
        protected set

    @LastModifiedBy
    var updatedBy: String = "system"
}
