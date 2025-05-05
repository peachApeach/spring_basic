package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 기존에 있는 AppConfig를 Bean에 넣지 않기 위하여 excludeFilters로 제외 규칙 생성
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
