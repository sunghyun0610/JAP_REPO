package hellojpa;

import jakarta.persistence.*;




public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//데이터베이스 당 하나씩 묶여서 돌아감.
        //entityMangerFactory 만드는 순간 DB연결은 가능
        EntityManager em = emf.createEntityManager();//공장에서 entitymanager꺼내는 코드
            //em을 자바컬렉션처럼 이해하면 좋음, 내 객체를 대신 저장해주는 것.
            EntityTransaction tx = em.getTransaction();//JPA 는 transaction이 매우 중요하다
            tx.begin();
            try {
            tx.commit(); // 트랜잭션이 커밋(commit)되는 시점에 데이터베이스에 반영됩니다.
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();//entity manger 꼭 닫아줄 것!
        }
        emf.close();

    }
}

