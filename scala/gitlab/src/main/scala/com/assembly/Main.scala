package com.assembly

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class Application

object Main extends App {
  SpringApplication.run(classOf[Application], args:_*)
}