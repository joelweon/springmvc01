/* 주제: 파라미터의 존재 여부에 따라 호출을 결정할 수 있다.
 * => @RequestMapping의 속성을 이용하여 설정한다.
 */
package springmvc01.control.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control04 {
  /*ex2/control04.jsp로 테스트 하라!*/
  
  @RequestMapping(value="/ex2/param", params={"aaa"})
  public void aaa() {
    System.out.println("aaa");
  }
  
  @RequestMapping(value="/ex2/param", params="bbb") // 값이 하나 일 때는 중괄호 생략가능
  public void bbb() {
    System.out.println("b");
  }
  
  // method 속성을 지정하지 않으면 get과 post 요청 모두 처리한다.
  @RequestMapping(value="/ex2/param", params={"aaa","bbb"})
  public void aaabbb() { 
    System.out.println("ab");
  }
}
