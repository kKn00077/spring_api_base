package kr.co.moreturn.hwizza.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
* @packageName : kr.co.moreturn.hwizza.utils.exception 
* @fileName : HwizzaException.java 
* @author : Gyuna Kim 
* @date : 2021.09.21 
* @description : 예외 클래스 생성
* =========================================================== 
* DATE              AUTHOR             NOTE
* ----------------------------------------------------------- 
* 2021.09.21        Gyuna Kim          최초 생성 
*/

@Getter
@AllArgsConstructor
public class HwizzaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ErrorCode errorCode;
}
