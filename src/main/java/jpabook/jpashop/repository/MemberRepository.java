package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 스프링 빈으로 등록
@RequiredArgsConstructor
public class MemberRepository {

    // JPA의 핵심 인터페이스인 EntityManager를 스프링 컨테이너가 관리하는 컴포넌트에 주입
    // 영속성 컨텍스트 관리: 이 어노테이션을 통해 주입된 EntityManager는 영속성 컨텍스트(Persistence Context)를 사용해 엔티티 객체의 상태를 관리한다.
    /* entityManager.persist(Object entity): 엔티티를 영속성 컨텍스트에 추가.
       entityManager.remove(Object entity): 엔티티를 영속성 컨텍스트에서 제거.
       entityManager.merge(Object entity): 준영속 상태 엔티티를 영속 상태로 병합. */
    @PersistenceContext
    private final EntityManager em;

  /*  public MemberRepository(EntityManager em) {
        this.em = em;
    }*/

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) { // 단건조회
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); // jpql : sql과 기능적으로 동일하지만 엔티티 객체를 대상으로 함
    }

    public List<Member> findByName(String name) { // 특정 회원만 조회
        return em.createQuery("select m from Member m where m.name = : name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
