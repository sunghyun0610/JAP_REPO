package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity//이걸 넣어야지 jpa를 사용하는구나 인식함
//@Table(name="USER") 이테이블 이름으로 맵핑
public class Member {
    @Id//PK매핑= 기본키
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")//@Column(name = "name")// 객체는 username인데 DB에는 name에 저장하고 싶을때
    private String username;

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}