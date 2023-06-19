package hello2.hello2spring.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hello2.hello2spring.domain.Member;

import hello2.hello2spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;



class MemberServiceTest {
    MemberService memberService ;
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void beforeEach(){ //각 테스트 실행전에 실행
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); // 테스트  실행되고 끝날때마다 저장소 지워지기
    }

    @Test
    void 회원가입(){
        //given  뭔가 주어짐
        Member member = new Member();
        member.setName("hello");

        //when  이것을 실행할때
        Long saveId = memberService.join(member); // return id

        //then  결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
        //Asertions 검증 (assertj)
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e =   assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
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