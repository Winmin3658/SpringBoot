package com.kh.mallapi;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.repository.TodoRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MallapiApplicationTests {
	@Autowired
	private TodoRepository todoRepository;

	// @Test
	void contextLoads() {
		// Todo 테이블에 insert 기능 = jpa.save(entity) 기능
		for (int i = 1; i <= 100; i++) {
			Todo todo = Todo.builder().title("Title" + i).dueDate(LocalDate.of(2025, 7, 15))
					.writer("kdj00").build();
			todoRepository.save(todo);
		}
	}

	// @Test
	// todo, get select * from todo where tno = ? === findById(id)
	void testRead() {
		Long tno = 20L;
		Optional<Todo> result = todoRepository.findById(tno);
		Todo todo = result.orElseThrow();
		log.info(todo);
	}

	// @Test
	// 수정을 하기 위해서 findById(id) => Todo(정보가 이미 들어있음) => Todo setter 수정한다. =>
	// save(Entity)
	// save(Entity) 해당되는 Tno가 있으면
	void testModify() {
		Long tno = 20L;
		Optional<Todo> result = todoRepository.findById(tno);
		Todo todo = result.orElseThrow();
		todo.changeComplete(true);
		todo.changeWriter("lee00");
		todo.changeDueDate(LocalDate.of(2024, 7, 7));
		todoRepository.save(todo);
	}

	// 삭제하기
	@Test
	void testDelete() {
		Long tno = 20L;
		todoRepository.deleteById(tno);
	}
}
