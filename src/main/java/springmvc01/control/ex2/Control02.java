/* 주제: 뷰 컴포넌트 관리자 교체하기
 * => 특정 폴더에서 JSP를 찾도록 기존의 뷰 컴포넌트 관리자를 교체한다.
 * => 스프링 설정파일(dispatcher-servlet.xml)에 해당 객체를 추가한다.
 *    이 객체를 추가하면 기존 객체 대신 새로 추가한 객체를 
 *    뷰 컴포넌트 관리자로 사용할 것이다.
 * */
package springmvc01.control.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control02 {
  
  @RequestMapping("/ex2/test01")
  public String text01() {
//    새로 등록한 뷰 컴포넌트 관리자는 리턴 값 앞, 뒤로 경로를 붙이기 때문에
//    JSP 경로를 리턴할 때 이런 것을 고려하자!
    return "ex2/test01";
  }
  
  /* 만약 리턴 값을 지정하지 않으면,
   * 뷰 URL로 요청 URL을 사용한다.
   * 뷰 컴포넌트 관리자(View resolver)는 다음 공식에 따라 뷰 URL을 결정한다.
   * => 뷰 URL = 접두어 + 요청URL + 접미사 = "/" + "/ex2/test02 + ".jsp" = /ex2/test02.jsp
   * => 단 앞에 /가 겹쳐 있으면 한 개로 만든다.
   * */
  @RequestMapping("/ex2/test02")
  public void text02() { // 같은경로에 jsp 파일이 있으면 리턴안해도 된다. 알아서 찾는다.
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

