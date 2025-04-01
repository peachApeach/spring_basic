package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;

public class AppConfig {

    // MemberService 구현체 설정 -> 생성자를 통해서 구현체 결정
    // MemberRepository memberRepository = new MemoryMemberRepository
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

}
