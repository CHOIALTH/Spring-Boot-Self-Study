package hello.hellospring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
    /* PK를 매핑시켜줘야 함*/
    @Id
    /* DB가 알아서 id를 생성해줌*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*데이터 구분을 위한 임의의 값. 식별자*/
    private Long id;
    /*고객이 회원가입시 적는 이름*/
    private String name;
    /*Alt + Insert 단축키로 손쉽게 Getter / Setter 코드 작성 가능*/

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
