package hello2.hello2spring.repository;


import hello2.hello2spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository =  new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore(); // 테스트  실행되고 끝날때마다 저장소 지워지기
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member); //repository 저장소 , db있는 값

        Member result  = repository.findById(member.getId()).get();

       // System.out.println("result = "+(result == member));
       // Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result); // member가 result와 같다?Z

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
       // System.out.println(result);
        assertThat(result.size()).isEqualTo(2);

    }

}
