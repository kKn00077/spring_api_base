package kr.co.moreturn.hwizza.utils.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @packageName : kr.co.moreturn.hwizza.utils.exception 
* @fileName : ErrorCode.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 예외 발생 시 사용할 에러코드
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    NOT_ENOUGH_ATTRIBUTE(HttpStatus.BAD_REQUEST, "필수 JSON 속성값이 없습니다"),
    CANNOT_FOLLOW_MYSELF(HttpStatus.BAD_REQUEST, "자기 자신은 팔로우 할 수 없습니다"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "로그인 정보 불일치로 로그인을 할 수 없습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    // TODO

    ;
     
	private final HttpStatus httpStatus;
    private final String detail;
}