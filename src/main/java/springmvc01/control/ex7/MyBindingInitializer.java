package springmvc01.control.ex7;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyBindingInitializer implements WebBindingInitializer {//바인딩을 초기에 설정해주는 애

  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //매번 객체생성은 낭비-> 여기로 뻄.

  @Override
  public void initBinder(WebDataBinder binder, WebRequest request) {
    System.out.println("MyBindingInitializer.initBinder()....");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}

/* 이 객체를 스프링 설정 파일에 등록해야 한다.
=> Spring 2.5 방식
<bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
    <property name="cacheSeconds" value="0"/>
    <property name="webBindingInitializer">
        <bean class="springmvc01.control.ex7.MyBindingInitializer"/>
    </property>
</bean> 

=> Spring 3.2 방식
1) MVC 관련 애노테이션을 다룰 객체를 등록해야 한다.
<mvc:annotation-driven/>  
2) 전역에서 사용할 수 있도록 커스텀 에디터를 등록한다.
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
    <property name="order" value="0" /> <== 주의! 적용 순서를 최우선으로 해야 한다.
    <property name="cacheSeconds" value="0"/>
    <property name="webBindingInitializer">
        <bean class="springmvc01.control.ex7.MyBindingInitializer"/>
    </property>
</bean> 

=> Spring 4.0 방식
@ControllerAdvice 애노테이션을 사용하여 설정한다.

 */