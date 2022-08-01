package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{


    //이 코드안에는 메모리멤버레파지토리에 대한 코드가 없고
    //멤버레파지토리에 인터페이스만 있음으로 추상화에만 의존하는 것 이다.
    //DIP를 지킨다.
    private final MemberRepository memberRepository;

    //생성자를 통해서 AppConfig로부터 레파지토리를 선택받는다.

    @Autowired //자동의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.sava(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //test용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
