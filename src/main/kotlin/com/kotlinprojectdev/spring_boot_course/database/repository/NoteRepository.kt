package com.kotlinprojectdev.spring_boot_course.database.repository

import com.kotlinprojectdev.spring_boot_course.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository : MongoRepository<Note, ObjectId> {

    fun findByOwnerId(ownerId: ObjectId) : List<Note>


}