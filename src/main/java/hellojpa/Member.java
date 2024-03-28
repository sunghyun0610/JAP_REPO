package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity//이걸 넣어야지 jpa를 사용하는구나 인식함
//@Table(name="USER") 이테이블 이름으로 맵핑
public class Member {
    @Id//PK매핑
    private Long id;

    @Column(name = "name")//@Column(name = "name")// 객체는 username인데 DB에는 name에 저장하고 싶을때
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)//DB에는 enumtype이 없으므로 @Enumerated 어노테이션 써야댐.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)//
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob//Varchar을 넘어서는 큰 컨텐츠
    private String description;

    public Member() {

    }
}
