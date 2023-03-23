package hello.hellospring.controller;

public class MemberForm {
    /* createMemberForm.html의 form 태그 내 input 태그의 name="name"과 연결됨*/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
