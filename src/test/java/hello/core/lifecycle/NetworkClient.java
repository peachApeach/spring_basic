package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    // 가상 네트워크 클라이언트

    // 접속해야 할 url
    private String url;

    // 디폴트 생성자
    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    // 외부 입력
    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출하는 메서드
    public void connect() {
        System.out.println("connect " + url);
    }

    // connect 후 콜 할 수 있다고 가정
    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    // 의존 관계 주입 후 호출
    @PostConstruct
    public void init() {
        System.out.println("afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    // 소멸 전 콜백
    @PreDestroy
    public void close() {
        System.out.println("destroy");
        disconnect();
    }
}
