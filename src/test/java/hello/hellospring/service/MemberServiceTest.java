package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memoryMemberRepository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hw");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateException() {
        //given
        Member member1 = new Member();
        member1.setName("mh");

        Member member2 = new Member();
        member2.setName("mh");

        //when
        memberService.join(member1);


        //then

        /**
         * 예외 처리 방법 CASE 1
         * - try{} catch{}
         */

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

// end of CASE 1

        /**
         * CASE 2
         * 메시지 검증 X
         */

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // lamda -> memberService.join(member2) 로직을 실행했을 때, IllegalStateException 예외가 발생해야 한다.

// end of CASE 2

        /**
         * CASE 3
         * 메시지 검증
         */
        /*
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        */
//end of CASE 3
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}