package com.kh.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kh.mallapi.domain.Todo;

//c save, u findByid() => setter => save, r findByid(), d 설정 deleteByid
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
