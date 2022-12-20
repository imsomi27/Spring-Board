package com.studysetting.domain.board.entity;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
//import com.studysetting.domain.board.entity.QBoard;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
	private final JPAQueryFactory jpaQueryFactory;
	
}