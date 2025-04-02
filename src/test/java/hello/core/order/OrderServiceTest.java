package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    // MemberService memberService = new MemberServiceImpl();
    // OrderService orderService = new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;

    // 테스트 시작 전 반드시 실행하는 것
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(Grade.VIP, "memberA", memberId);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"item1",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
