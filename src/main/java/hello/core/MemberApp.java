package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //spring은 모두 ApplicationContext로 시작 (컨테이너)
        //아래 구문으로 인하여 AppConfig에 있는 정보를 토대로 스프링 사용가능
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //메서드 이름과 클래스(반환 타입) 명시
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(Grade.VIP, "memberA", 1L);
        memberService.join(member);

        // 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
