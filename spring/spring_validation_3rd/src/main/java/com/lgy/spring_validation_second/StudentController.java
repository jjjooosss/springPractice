package com.lgy.spring_validation_second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
//    public String studentCreate(Student student, BindingResult result){
    public String studentCreate(@Valid Student student, BindingResult result){
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
//    @Valid Student 객체를 받아서 유효성 체크
    @InitBinder
    public void initBinder(WebDataBinder binder){
//        Student 객체를 binder로 받아서 StudentController 객체를 사용해서 유효성체크
        binder.setValidator(new StudentValidator());
    }
}
