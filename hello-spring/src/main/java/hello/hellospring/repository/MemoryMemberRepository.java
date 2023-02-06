package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    /* Map<key, value>*/
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        /*요즘엔 null이 발생할 간으성이 있으면 Optional로 감싸서 반환함*/
        /*그러면 클라이언트에서 무언가 할 수 있다. 나중 강의에서 추가 설명됨*/
        return Optional.ofNullable(store.get(id)) ;
    }

    @Override
    public Optional<Member> findByName(String name) {
        /*lambda 활용*/
        /*loop를 돌리는 것*/
        return store.values().stream()
                /*meber.getName이 파라미터로 넘어온 name과 같은 경우에만 필터링 됨 */
                .filter(member -> member.getName().equals(name))
                /*하나라도 찾으면 반환하고, 끝까지 없으면 Optional에 null이 포함되어 반환됨*/
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        /*store.values() = 안에 담긴 멤버들 */
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
