package com.ga5000.todolist;

import com.ga5000.todolist.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo 1","desc todo 1",false,1);

		webTestClient
				.post()
				.uri("/todos/create")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$").exists();
	}

	@Test
	void testCreateTodoFailure(){
		var todo = new Todo("","",false,0);

		webTestClient
				.post()
				.uri("todos/create")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
