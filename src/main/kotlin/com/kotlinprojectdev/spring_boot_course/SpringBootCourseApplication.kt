package com.kotlinprojectdev.spring_boot_course

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootCourseApplication

fun main(args: Array<String>) {
	runApplication<SpringBootCourseApplication>(*args)
}
