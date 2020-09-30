package ar.edu.unq.devit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [MongoAutoConfiguration::class])
class DevitApplication

fun main(args: Array<String>) {
	runApplication<DevitApplication>(*args)
}
