package com.example.accountservice.account.controller

import com.example.accountservice.account.dto.AccountDto
import com.example.accountservice.account.model.Account
import com.example.accountservice.account.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Shared
import spock.lang.Specification

class AccountControllerTest extends Specification {
    def accountService = Mock(AccountService)
    def accountController = new AccountController(accountService)

    @Shared
    def account = new Account(number:"123123123")

    def "Save"() {
        setup:
        def accountDto = new AccountDto(number: "123123123", clientName: "jhon doe")

        when: "post is called"
        def result = accountController.post(accountDto)

        then:
        1 * accountService.save(accountDto) >> ResponseEntity.status(HttpStatus.CREATED).body(new Account())

        and:
        result != null && result.getBody() instanceof Account
    }

    def "Get"() {
        setup:
        def accountId = 123L

        when: "get is called"
        def result = accountController.get(accountId)

        then:
        1 * accountService.get(accountId) >> ResponseEntity.ok(new Account())

        and:
        result != null && result.getBody() instanceof Account
    }

    def "Put"() {
        setup:
        def accountId = 123L

        when: "update is called"
        def result = accountController.put(accountId, account)

        then:
        1 * accountService.update(accountId, account) >> ResponseEntity.status(HttpStatus.CREATED).body(new Account())

        and:
        result != null && result.getBody() instanceof Account
    }

    def "Patch"() {
        setup:
        def accountId = 123L
        def accountDto = new AccountDto(number: "123123123")

        when: "update is called"
        def result = accountController.patch(accountId, accountDto)

        then:
        1 * accountService.patch(accountId, accountDto) >> ResponseEntity.status(HttpStatus.CREATED).body(new Account())

        and:
        result != null && result.getBody() instanceof Account
    }

    def "Delete"() {
        setup:
        def accountId = 123L

        when: "delete is called"
        def result = accountController.delete(accountId)

        then:
        1 * accountService.delete(accountId) >> ResponseEntity.noContent().build()

        and:
        result != null && result.getStatusCode() == HttpStatus.NO_CONTENT
    }
}
