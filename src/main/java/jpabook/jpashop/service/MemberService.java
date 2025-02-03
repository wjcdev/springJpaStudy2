package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
// RequiredArgsConstructor : Lombok 라이브러리에서 제공하는 어노테이션
// 클래스의 final 필드와 @NonNull 필드에 대해 생성자를 자동으로 생성
// 이를 통해 불변 객체를 간단히 생성할 수 있습니다.
@RequiredArgsConstructor(onConstructor_=@Autowired)
public class MemberService {


    private final MemberRepository memberRepository;

  /*  @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 생성자 인젝션
    }*/

    /**
     * 회원 가입
     */
    @Transactional // readOnly = false
    public long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); // memberName을 유니크 제약 조건 거는 것이 안전하다.
        // System.out.println("Found members: " + findMembers.size());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    /**
     * 회원 수정
     * @param id
     * @param name
     */
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

}
