(ns com.assembly.github.core
  (:import (org.springframework.boot SpringApplication))
  (:gen-class
    :name ^{org.springframework.boot.autoconfigure.SpringBootApplication []
            org.springframework.context.annotation.ComponentScan {:basePackages ["com.assembly.github"]}}
    com.assembly.github.core.Application
    :main true)
  )

(defn -main []
  (SpringApplication/run (Class/forName "com.assembly.github.core.Application") (into-array String '()))
  )
