package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity//이걸 넣어야지 jpa를 사용하는구나 인식함
public class Member {
    @Id
    private Long id;
    private String name;
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
