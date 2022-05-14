package kr.co.moreturn.hwizza;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
* @packageName : kr.co.moreturn.hwizza 
* @fileName : HwizzaBackendApplication.java 
* @author : Gyuna Kim 
* @date : 2021.09.17 
* @description : 스프링 부트 기본 세팅 클래스
* Component Scan의 경우 @SpringBootApplication 어노테이션 내부에서 자동으로 설정해준다.
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.17        Gyuna Kim          최초 생성
 */

@SpringBootApplication
@MapperScan("kr.co.moreturn.hwizza.**.mapper")
public class HwizzaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwizzaBackendApplication.class, args);
	}

}
