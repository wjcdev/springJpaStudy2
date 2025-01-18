package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    // @Rollback(false)
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1); // 첫 번째 회원 저장
        em.flush(); // DB에 반영
        em.clear(); // 영속성 컨텍스트 초기화

        // then
        /*  try {
            memberService.join(member2); // 중복 예외 발생
        } catch (IllegalStateException e) {
            Assertions.fail("IllegalStateException이 발생해야 합니다.");
        }*/

        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                memberService.join(member2); // 중복 예외 발생
            } catch (IllegalStateException e) {
                System.out.println("예외 발생 메시지: " + e.getMessage());
                throw e;
            }
        });
    }
}