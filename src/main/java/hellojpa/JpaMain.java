package hellojpa;

import jakarta.persistence.*;




public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //entityMangerFactory 만드는 순간 DB연결은 가능
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();//JPA 는 transaction이 매우 중요하다
        tx.begin();

        //code
        Member member = new Member();
        member.setId(2L);
        member.setName("HelloB");
        em.persist(member);

        tx.commit();

        em.close();
        emf.close();
    }
}
