package com.studysetting.domain.User.entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByUserEmail(String userEmail);
	//중복가입
	boolean existsByuserEmail(String userEmail);
//	boolean existsByNickname(String nickname);
}