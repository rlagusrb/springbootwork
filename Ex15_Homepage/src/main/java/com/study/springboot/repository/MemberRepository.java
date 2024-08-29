package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
