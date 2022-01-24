package vn.codegym.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {


    @AfterReturning(pointcut = "execution(* vn.codegym.ung_dung_muon_sach.controller.BookController.*(..))")
    public void LogMethodReturn(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Tên phương thức là: " + name);
        System.err.println("Các tham số là: " + args);
    }

    @AfterReturning(pointcut = "execution(* vn.codegym.ung_dung_muon_sach.controller.BookController.rentBook(..))")
    public void LogRentBook(JoinPoint joinPoint){
        System.err.println("Đã mượn 1 cuốn sách");
    }
}
