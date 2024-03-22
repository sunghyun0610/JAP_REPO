package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//이걸 넣어야지 jpa를 사용하는구나 인식함
//@Table(name="USER") 이테이블 이름으로 맵핑
public class Member {
    @Id
    private Long id;
    //@Column(name = "username")// 매핑가능ㅇ
    private String name;

    public Member(){

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter setter -> alt+insert
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
