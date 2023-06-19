package hello2.hello2spring.service;

import hello2.hello2spring.domain.Member;
import hello2.hello2spring.repository.MemberRepository;
import hello2.hello2spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository ;

   // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회워가입
         */
    public Long join(Member member) {
        //같은이름이 있는 중복회원은 안된다.
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m ->{ //result에 값이 있으면 아래 로직 동작
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member);//중복회원검증
        memberRepository.save(member);
        return member.getId();
     }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{ // 멤버 m 에 값이 있으면 즉 널이 아니면
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        }); // 어처피 옵셔널로 반환됨
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
