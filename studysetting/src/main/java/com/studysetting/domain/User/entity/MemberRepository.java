package com.studysetting.domain.User.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByemail(String email);
	//중복가입
	boolean existsByemail(String email);
	boolean existsByNickname(String nickname);
}