package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingleToneTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 조회: 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingleToneServiceTest () {
        // private으로 생성자를 막아둔 상태
        // SingleToneService singleToneService1 = new SingleToneService(); 을 사용하면 컴파일 오류 발생
        // 조회 호출할 때마다 같은 객체를 반환
        SingleToneService singleToneService1 = SingleToneService.getInstance();
        SingleToneService singleToneService2 = SingleToneService.getInstance();

        System.out.println("singletonService1 = " + singleToneService1);
        System.out.println("singletonSerivce2 = " + singleToneService2);

        assertThat(singleToneService1).isSameAs(singleToneService2);
        singleToneService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 호출할 때마다 같은 객체 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
