package com.kotlinprojectdev.spring_boot_course.controllers

import com.kotlinprojectdev.spring_boot_course.controllers.NoteController.NoteResponse
import com.kotlinprojectdev.spring_boot_course.database.model.Note
import com.kotlinprojectdev.spring_boot_course.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*
import java.time.Instant

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

    @PostMapping
    fun saveNote(body: NoteRequest): NoteResponse {

      val note = repository.save(

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
        return note.toResponse()
    }

    @GetMapping
    fun findByOwnerId(
        @RequestParam(required = true)
        ownerId: String
    ): List<NoteResponse> {
        return repository.findByOwnerId(ObjectId(ownerId)).map {
            it.toResponse()
        }
    }

}

private fun Note.toResponse(): NoteController.NoteResponse {
    return NoteResponse(
        id = id.toHexString(),
        title = title,
        content = title,
        color = color,
        createdAt = createdAt
    )
}