package com.kh.mallapi;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.TodoDTO;
import com.kh.mallapi.repository.TodoRepository;
import com.kh.mallapi.service.TodoService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MallapiApplicationTests {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private TodoService todoService;

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
	// @Test
	void testDelete() {
		Long tno = 20L;
		todoRepository.deleteById(tno);
	}

	// paging 처리 방식
	// @Test
	void testPaging() {
		// 1페이지, 10개만 가져와라, tno 내림차순으로 가져와라.(리액트)
		Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());
		Page<Todo> result = todoRepository.findAll(pageable);
		log.info("전체 개수" + result.getTotalElements());
		// 현재 페이지 10개를 보여줄 것
		result.getContent().stream().forEach(todo -> log.info(todo));
	}

	// TodoDTO 값을 서비스를 이용해서 다형성처리 저장(컨트롤러 받은 값을 서비스에 저장)
	// @Test
	void testRegister() {
		TodoDTO todoDTO = TodoDTO.builder().title("입력 테스트").writer("kdj")
				.dueDate(LocalDate.of(2025, 7, 16)).build();
		Long tno = todoService.register(todoDTO);
		log.info("TNO" + tno);
	}

	// @Test
	/*
	 * void testGet() {
	 * Long tno = 101L;
	 * TodoDTO todoDTO = todoService.builder().tno(tno).build();
	 * TodoDTO _todoDTO = todoService.get(todoDTO);
	 * log.info(_todoDTO);
	 * }
	 */

	// 넘버리스트
	// @Test
	void testNumber() {
		List<Integer> listInteger = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		log.info(listInteger.toString());
	}

	// 페이징리스트
	// @Test
	void testList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(2).size(10).build();
		PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);
		log.info(response);
	}
}
