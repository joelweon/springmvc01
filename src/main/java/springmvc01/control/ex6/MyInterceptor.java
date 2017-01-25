package springmvc01.control.ex6;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("MyInterceptor.preHandler()");
    // true : 다음 인터셉터를 호출한다. 없으면 페이지 컨트롤러의 메서드 호출한다. 
    // false : 바로 응답한다.
    return true;
  }//페이지 컨트롤 실행 전
  
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("MyInterceptor.postHandle");
  }//페이지 컨트롤 실행 후 & jsp 실행전 꼽기 // 모든 jsp에게 공통으로 줄 것을 작업
  
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("MyInterceptor.afterCompletion");
  }//jsp 호출 후 실행 할 부분 // 추가적으로 실행할 작업
}

/*구현은 셋 중에 하나 할 것이다.
로그인 되었나 안되었나 확인할 때 많이 쓰인다.*/