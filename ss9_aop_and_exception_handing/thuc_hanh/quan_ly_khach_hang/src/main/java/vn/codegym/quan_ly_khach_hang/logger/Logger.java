package vn.codegym.quan_ly_khach_hang.logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    public void error() {
        System.out.println("[CMS] ERROR!");
    }


}