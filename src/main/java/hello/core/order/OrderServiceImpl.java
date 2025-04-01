package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //final은 값을 반드시 할당하도록 
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // ocp 및 dip에 위배되지 않도록 인터페이스만 선언
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 확인
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인 정책 포함된 주문 내역 전달
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
