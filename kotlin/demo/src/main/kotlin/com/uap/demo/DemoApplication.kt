package com.uap.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
