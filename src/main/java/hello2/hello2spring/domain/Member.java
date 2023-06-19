package hello2.hello2spring.domain;

public class Member {


    private Long id; //데이터구분하기 위해 , 시스템이 저장하는 id
    private String name; //이름

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
