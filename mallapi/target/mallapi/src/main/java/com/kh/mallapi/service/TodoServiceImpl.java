package com.kh.mallapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mallapi.domain.Todo;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.TodoDTO;
import com.kh.mallapi.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	// 생성자 의존성 주입
	private final TodoRepository todoRepository;
	private final ModelMapper modelMapper;

	@Override
	public Long register(TodoDTO todoDTO) {
		Todo todo = modelMapper.map(todoDTO, Todo.class);
		Todo saveTodo = todoRepository.save(todo);

		return saveTodo.getTno();
	}

	@Override
	public TodoDTO get(TodoDTO todoDTO) {
		Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
		Todo todo = result.orElseThrow();
		TodoDTO _todoDTO = modelMapper.map(todo, TodoDTO.class);

		return _todoDTO;
	}

	@Override
	public void modify(TodoDTO todoDTO) {
		Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
		Todo todo = result.orElseThrow();

		todo.changeTitle(todoDTO.getTitle());
		todo.changeDueDate(todoDTO.getDueDate());
		todo.changeComplete(todoDTO.isComplete());
		
		todoRepository.save(todo);
	}

	@Override
	public void remove(TodoDTO todoDTO) {
		todoRepository.deleteById(todoDTO.getTno());
	}

	@Override
	//2. pageRequestDTO
	public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
		//페이지정보 PageRequestDTO, 목록리스트, 엔티티 전체개수 PageResponseDTO<TodoDTO>
		Pageable pageable = PageRequest.of(pageRequestDTO.getPage() - 1, 
				pageRequestDTO.getSize(), Sort.by("tno").descending());
		
		Page<Todo> result = todoRepository.findAll(pageable);
		
		//1. 1페이지 10개  (10개의 레코드가 들어있다.) 
		List<TodoDTO> dtoList = result.getContent().stream().map(todo ->
				modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
		
		//3. 전체갯수
		long totalCount = result.getTotalElements();

		//생성자(List<TodoDTO>, PageRequestDTO, totalCount)
		PageResponseDTO<TodoDTO> responseDTO = PageResponseDTO.<TodoDTO>withAll()
				.dtoList(dtoList).pageRequestDTO(pageRequestDTO).totalCount(totalCount).build();
		
		return responseDTO;
	}

}
