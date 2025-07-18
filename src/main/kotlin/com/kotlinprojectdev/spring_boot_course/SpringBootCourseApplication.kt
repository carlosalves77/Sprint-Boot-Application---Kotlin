package com.kotlinprojectdev.spring_boot_course

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [MongoAutoConfiguration::class],
)
class SpringBootCourseApplication

fun main(args: Array<String>) {
    runApplication<SpringBootCourseApplication>(*args)
}
