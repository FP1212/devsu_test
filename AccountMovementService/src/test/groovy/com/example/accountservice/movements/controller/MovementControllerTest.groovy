package com.example.accountservice.movements.controller

import com.example.accountservice.movements.dto.MovementDto
import com.example.accountservice.movements.model.Movement
import com.example.accountservice.movements.service.MovementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Shared
import spock.lang.Specification

class MovementControllerTest extends Specification {
    def movementService = Mock(MovementService)
    def movementController = new MovementController(movementService)

    @Shared
    def movement = new Movement(number:"123123123")

    def "Save"() {
        when: "post is called"
        def result = movementController.post(movement)

        then:
        1 * movementService.save(_ as Movement) >> ResponseEntity.status(HttpStatus.CREATED).body(new Movement())

        and:
        result != null && result.getBody() instanceof Movement
    }

    def "Get"() {
        setup:
        def movementId = 123L

        when: "get is called"
        def result = movementController.get(movementId)

        then:
        1 * movementService.get(movementId) >> ResponseEntity.ok(new Movement())

        and:
        result != null && result.getBody() instanceof Movement
    }

    def "Put"() {
        setup:
        def movementId = 123L

        when: "update is called"
        def result = movementController.put(movementId, movement)

        then:
        1 * movementService.update(movementId, movement) >> ResponseEntity.status(HttpStatus.CREATED).body(new Movement())

        and:
        result != null && result.getBody() instanceof Movement
    }

    def "Patch"() {
        setup:
        def movementId = 123L
        def movementDto = new MovementDto(number: "123123123")

        when: "update is called"
        def result = movementController.patch(movementId, movementDto)

        then:
        1 * movementService.patch(movementId, movementDto) >> ResponseEntity.status(HttpStatus.CREATED).body(new Movement())

        and:
        result != null && result.getBody() instanceof Movement
    }

    def "Delete"() {
        setup:
        def movementId = 123L

        when: "delete is called"
        def result = movementController.delete(movementId)

        then:
        1 * movementService.delete(movementId) >> ResponseEntity.noContent().build()

        and:
        result != null && result.getStatusCode() == HttpStatus.NO_CONTENT
    }
}
