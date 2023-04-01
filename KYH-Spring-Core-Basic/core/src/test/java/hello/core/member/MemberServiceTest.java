package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given(~환경 주어졌을 때)
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when(~하면)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then(~된다)
        //join한 것과 찾은 것 똑같냐? 테스트가 됨(JUnit)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
