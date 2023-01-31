package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    /*Optional은 java8의 기능으로, 
    요즘에는 값이 없을때 단순히 null 처리하는 게 아니라 Optional로 감싸서 주로 반환함 */
    
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
