package com.example.clientservice.client.controller

import com.example.clientservice.client.dto.ClientDto
import com.example.clientservice.client.model.Client
import com.example.clientservice.client.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Shared
import spock.lang.Specification

class ClientControllerTest extends Specification {
    def clientService = Mock(ClientService)
    def clientController = new ClientController(clientService)

    @Shared
    def client = new Client(id:123L, name: "jhon doe", address: "street 123", phone: "35 47788", password: "secretPass", status: true)

    def "Save"() {
        when: "post is called"
        def result = clientController.post(client)

        then:
        1 * clientService.save(_ as Client) >> ResponseEntity.status(HttpStatus.CREATED).body(new Client())

        and:
        result != null && result.getBody() instanceof Client
    }

    def "Get"() {
        setup:
        def clientId = 123L

        when: "get is called"
        def result = clientController.get(clientId)

        then:
        1 * clientService.get(clientId) >> ResponseEntity.ok(new Client())

        and:
        result != null && result.getBody() instanceof Client
    }

    def "GetByName"() {
        def clientName = "jhon doe"

        when: "get is called"
        def result = clientController.getByName(clientName)

        then:
        1 * clientService.getByName(clientName) >> ResponseEntity.ok(new Client())

        and:
        result != null && result.getBody() instanceof Client
    }

    def "Put"() {
        setup:
        def clientId = 123L

        when: "update is called"
        def result = clientController.put(clientId, client)

        then:
        1 * clientService.update(clientId, client) >> ResponseEntity.status(HttpStatus.CREATED).body(new Client())

        and:
        result != null && result.getBody() instanceof Client
    }

    def "Patch"() {
        setup:
        def clientId = 123L
        def clientDto = new ClientDto(name:"jane doe")

        when: "update is called"
        def result = clientController.patch(clientId, clientDto)

        then:
        1 * clientService.patch(clientId, clientDto) >> ResponseEntity.status(HttpStatus.CREATED).body(new Client())

        and:
        result != null && result.getBody() instanceof Client
    }

    def "Delete"() {
        setup:
        def clientId = 123L

        when: "delete is called"
        def result = clientController.delete(clientId)

        then:
        1 * clientService.delete(clientId) >> ResponseEntity.noContent().build()

        and:
        result != null && result.getStatusCode() == HttpStatus.NO_CONTENT
    }
}
