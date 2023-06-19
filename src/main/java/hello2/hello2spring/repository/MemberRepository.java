package hello2.hello2spring.repository;

import hello2.hello2spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장됨
    Optional<Member> findById(Long id);//id찾기
    Optional<Member> findByName(String name);//name찾기
    //optional 값이 널일경우 optional로 반환
    List<Member> findAll();//저장된 모든 데이터 리스트 반환

}

