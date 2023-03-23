package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    //clear해주고 싶은데 MemberService 밖에 없으므로 clear가 안된다. MemoryMemberRepository()를 가져와줘야함

    //MemoryMemberRepositoryTest의 MemoryMemberRepository()와 다른 인스턴스를 생성하는 꼴.. 불필요하게 중복코드가 되버린다
    //이를 해결하여 같은 instance를 사용하게 하려면 MemberService에서  = new MemoryMemberRepository() 를 지우고, Constructor을 넣어준다
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    
    //Test는 정상 flow도 중요하지만, 예외 flow가 훨씬 더 중요하다!

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        // @Test 실행되고 끝날때마다 저장소를 지워줘(DB의 값 다 날려줌).. 순서에 의해 발생하는 오류가 해결됨
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {
        //given ~가 주어졌는데
        Member member = new Member();
       //member.setName("hello");

        //spring을 이름의 값으로 주면, 이미 spring이 DB에 저장되었고 가입된 꼴임
        //따라서 중복_회원_예외() 내 첫번째 join에서 예외가 터져버림
        //member.setName("spring");
        //when ~를 실행했을때
        Long saveId = memberService.join(member);

        //then 결과가 ~~ 나와야해
        //assertThat 이 없을 것이다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        //같은 이름을 넣으면, validateDuplicateMember(member)에 걸려서 예외가 터져야함.
        //예외를 잡으려면 try-catch문으로 잡는 방법이 있다
        //memberService.join(member1);
        //memberService.join(member2);

        memberService.join(member1);
        //assertThrows는 발생하는 예외를 모든 예외 클래스의 선조 클래스인 Throwable 타입으로 반환함
        //Throwable으로 반환된 메서드에서 발생한 예외 객체의 메시지를 통하여 예외 메시지 테스트를 할 수 있음
        //예외가 발생하고 lambda로 넘어가야함
        //따라서, 콤마 우측의 로직이 실행되면 우측의 예외처리가 터지는 지 확인 가능하다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다. 중복!");
        //아래의 경우 test에 실패함
        //assertThrows(NullPointerException.class, () -> memberService.join(member2));
/*
        try{
            memberService.join(member2);
            fail();

        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다. 중복!");
        }
*/



        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}