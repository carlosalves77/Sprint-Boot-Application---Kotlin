package com.kotlinprojectdev.spring_boot_course.controllers

import com.kotlinprojectdev.spring_boot_course.database.model.Note
import com.kotlinprojectdev.spring_boot_course.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.Date

@RestController
@RequestMapping("/notes")
class NoteController(
    val repository: NoteRepository
) {

    data class NoteRequest(
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val ownerId: String
    )

    data class NoteResponse(
        val id: String,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant
    )

    @PostMapping("/notes/savenote")
    fun saveNote(body: NoteRequest): NoteResponse {

      val note =  repository.save(

            Note(
                id = body.id?.let {
                    ObjectId(it)
                } ?: ObjectId.get(),
                title = body.title,
                content = body.content,
                color = body.color,
                createdAt = Instant.now(),
                ownerId = ObjectId(body.ownerId)
            )
        )
        return NoteResponse(
            id = note.id.toHexString(),
            title = note.title,
            content = note.title,
            color = note.color,
            createdAt = note.createdAt
        )


    }
}