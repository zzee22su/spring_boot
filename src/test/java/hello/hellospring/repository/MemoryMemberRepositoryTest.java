package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
//    MemberRepository repository = new MemoryMemberRepository();


    @AfterEach //메소드 실행이 끝날 때 마다 동작한다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hw");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("hw");
        repository.save(member1);
        System.out.println("findByName hw : "+member1);

        Member member2 = new Member();
        member2.setName("mh");
        repository.save(member2);
        System.out.println("findByName mh : "+member2);

        Member result  = repository.findByName("hw").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("hw");
        repository.save(member1);
        System.out.println("findAll hw : "+member1);

        Member member2 = new Member();
        member2.setName("mh");
        repository.save(member2);
        System.out.println("findAll mh : "+member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
