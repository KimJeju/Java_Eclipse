package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//appconfig는 DI컨테이너(IOC 컨테이너) 이다.
//객체를 생성하고 관리하면서 의존관계를 주입해줌.

//공연기획자
//앱전체를 설정하고 구성하는 클래스

//스프링 설정정보
//순수한 appconfig
@Configuration
public class AppConfig {


    //역할을 분명히 나누어 줄 수 있다

    //중복을 제거할 수 있다.


    //멤버서비스 역할
    //@Bean : 스프링 컨테이너에 빈으로 등록
    @Bean
    public MemberService memberService(){
        //리파지토리 선택
        //생성자 주입
        System.out.println("call AppConfig.memberService");
        //new MemoryMemberRepository() 에 컨트롤 +  알트 + m 을 해주면 역할을 분리해주
//        return new MemberServiceImpl(new MemoryMemberRepository());
        return new MemberServiceImpl(MemberRepository());
    }


    //레파지토리 역할
    @Bean
    public MemoryMemberRepository MemberRepository() {
        System.out.println("call AppConfig.MemberRepository");
       //만약 멤버리포지토리를 변경할 것이면 이곳만 변경하면 된다.
        return new MemoryMemberRepository();
    }


    //오더서비스 역할
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        //할인정책과 멤버정보를 가져올 레파지토리 생성자주입
        return new OrderServiceImpl(MemberRepository(),discountPolicy());
    }

    //할인정책역할
    @Bean
    public DiscountPolicy discountPolicy(){
        //구현클래스가 한눈에 보인다.
        //디스카운트폴리시에 대한 구현체 fixDiscount
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
