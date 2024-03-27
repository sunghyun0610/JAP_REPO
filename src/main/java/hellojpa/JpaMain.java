package hellojpa;

import jakarta.persistence.*;




public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//데이터베이스 당 하나씩 묶여서 돌아감.
        //entityMangerFactory 만드는 순간 DB연결은 가능
        EntityManager em = emf.createEntityManager();
            //em을 자바컬렉션처럼 이해하면 좋음, 내 객체를 대신 저장해주는 것.
            EntityTransaction tx = em.getTransaction();//JPA 는 transaction이 매우 중요하다
            tx.begin();
            try {
                Member member1 =new Member(150L,"A");
                Member member2 =new Member(160L,"B");
                em.persist(member1);
                em.persist(member2);
                System.out.println("======================");
                em.persist(member1);//persist 메소드는 새로운 엔티티 인스턴스를 영속성 컨텍스트에 추가하는 역할
//                Member findMember= em.find(Member.class,101L);
//                System.out.println("findMemeber.id = " + findMember.getId());
//                System.out.println("findMemeber.name = " + findMember.getName());
//                findMember.setName("HelloJPA");// 수정 -> 어떻게 이렇게만해도 바뀌지?
                /*
                * Jpa를 통해서 entity를 가져오면 Jpa가 관리하기 시작. -> 변경점을 트랜잭션 commit직전에 체크 하고 적용시킨다.
                * */

                //em.remove(findMember);//삭제
//                System.out.println("findMember.id = " + findMember.getId());
//                System.out.println("findMember.name = " + findMember.getName()); 조회

            tx.commit(); // 트랜잭션이 커밋(commit)되는 시점에 데이터베이스에 반영됩니다.
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();//entity manger 꼭 닫아줄 것!
        }
        emf.close();

    }
}

