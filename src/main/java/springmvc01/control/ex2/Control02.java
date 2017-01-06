/* 주제: 뷰 컴포넌트 관리자 교체하기
 * => 특정 폴더에서 JSP를 찾도록 기존의 뷰 컴포넌트 관리자를 교체한다.
 * => 스프링 설정파일(dispatcher-servlet.xml)에 해당 객체를 추가한다.
 *    이 객체를 추가하면 기존 객체 대신 새로 추가한 객체를
 *    뷰 컴포넌트 관리자로 ##
 * */
package springmvc01.control.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control02 {
  
/* 
  */
  
  @RequestMapping("/ex2/test01")
  public String text01() {
//    리턴 값은 인클루드/포워드할 뷰 컴포넌트의 경로이다.
    return "/ex2/test01.jsp";
  }
  
  /* 
   * */
  @RequestMapping("/ex2/test02")
  public void text02() {
  }
}

/* 서블릿 구동 원리
 * 1) 웹브라우저는 톰캣서버에게 /ex1/test01.do 요청을 한다.
 * 2) 톰캣 서버는 *.do 요청을 처리하는 서블릿을 실행한다.
 * 3) DispatcherServlet은 자신이 갖고 있는 스프링 IoC  컨테이너에서
 *    "/ex1/test" 요청을 처리할 객체와 그 메서드를 찾는다.
 * 4) 메서드를 호출하기 전에 그 메서드가 파라미터 값으로 무엇을 원하는지 조사한다.
 * 5) 파라미터 값을 준비하고, 메서드를 호출할 때 넘긴다.
 * 6) 메서드가 리턴한 값을 가지고 JSP를 찾아 인클루드한다.
 * 7) 응답을 완료한다.
 * 8) 톰캣 서버는 DispatcherServlet이 완료한 응답을 웹브라우저에게 보낸다.
 * 9) 웹브라우저는 서버로부터 받은 콘텐츠를 화면에 그린다(rendering).
 */

