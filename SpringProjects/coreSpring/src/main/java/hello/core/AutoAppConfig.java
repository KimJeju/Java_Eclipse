package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정 정보에는 무조건 쓰자
@ComponentScan(                                             //Configuration 이라는 에노테이션이 붙은 클래스들은 스캔에서 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //스캔 중 뺄 것 설정
) //Bean 설정 정보를 자동으로 등록해준다.
public class AutoAppConfig {
}
