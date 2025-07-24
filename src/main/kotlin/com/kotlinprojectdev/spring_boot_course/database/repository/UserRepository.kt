package com.kotlinprojectdev.spring_boot_course.database.repository

import com.kotlinprojectdev.spring_boot_course.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {

    fun findByEmail(email: String): User?
}