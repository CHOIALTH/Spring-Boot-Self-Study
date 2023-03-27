package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface는 not 'implements' but 'extends'
// interface는 다중상속이 가능함
// JpaRepository<테이블명, 엔티티에서 식별자 PK의 타입>
// JpaRepository를 받고 있으면, SpringDataJpa가 interface에 대한 구현체를 자동으로 만들어줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
