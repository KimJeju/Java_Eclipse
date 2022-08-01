package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{



    //주문하는 회원정보를 담고있는 리포지토리
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //할인정책 (구현체에 의존하지 않고 인터페이스에만 의존한다.
    //DIP를 지킴 (Dependency Inversion principle) 추상 의존 O 구현 의존 X
    //생성자 주입

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //회원정보조회
        Member member = memberRepository.findById(memberId);

        //할인 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //주문반환
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }


    //test용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
