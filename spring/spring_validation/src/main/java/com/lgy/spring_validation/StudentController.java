package com.lgy.spring_validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class StudentController {
    @RequestMapping("/studentForm")
    public String studentForm(){
        return "createPage";
    }
//    Student : 커맨드 객체(dto로 주로 사용)
//    BindingResult : 스프링에서 제공하는 기본 validation
    @RequestMapping("/student/create")
    public String studentCreate(Student student, BindingResult result){
        String page ="createDonePage";

//        StudentValidator : 공통기능 validation 체크하는 클래스 객체
        StudentValidator validator = new StudentValidator();
        validator.validate(student, result);

//        errors.rejectValue 메소드가 호출되면 result.hasErrors() 가 참
        if (result.hasErrors()){
            log.info("@# result.hasErrors() id=>"+result.getFieldError("id"));
            log.info("@# result.hasErrors() pw=>"+result.getFieldError("pw"));
            page = "createPage";
        }
        return page;
    }

}
