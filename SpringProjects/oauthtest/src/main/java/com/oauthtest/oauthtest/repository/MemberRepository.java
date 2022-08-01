package com.oauthtest.oauthtest.repository;

import com.oauthtest.oauthtest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);
}
