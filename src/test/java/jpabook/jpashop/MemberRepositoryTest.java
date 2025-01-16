package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUserName("memberA");

        // when
        long saveId = memberRepository.save(member);
        System.out.println("Saved Member ID: " + member.getId());

        Member findMember = memberRepository.find(saveId);

        // then
        //Assertions.assertTrue(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
        //assertEquals(findMember.getId(), member.getId());
        //assertEquals(findMember.getUserName(), member.getUserName());
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }
}