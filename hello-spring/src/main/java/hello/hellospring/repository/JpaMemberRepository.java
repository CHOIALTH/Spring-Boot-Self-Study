package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository{

    /* 라이브러리에 data-jpa 추가하면, spring이 알아서 EntityManager 생성해줌 */
    /* 생성돼있는 EntityManager를 injection 받아서 사용하면 됨 */
    /* JPA를 사용하려면 EntityManger를 주입받아야 함 */
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        /* id는 PK라 아래와 같이 조회 가능*/
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        /* name은 PK가 아니므로, JPQL이라는 객체지향쿼리언어를 사용해야 함*/
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        /* findByName 으로 하나만 찾고자 하므로*/
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        /* JPQL이라는 객체지향 쿼리언어*/
        /* 보통 테이블 대상으로 쿼리를 날리는데
        객체(정확히는 엔티티)를 대상으로 쿼리를 날리는 것*/
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
