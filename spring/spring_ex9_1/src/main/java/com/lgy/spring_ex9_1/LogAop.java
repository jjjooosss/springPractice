package com.lgy.spring_ex9_1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
//		getSignature().toShortString() : 핵심기능 클래스의 메소드 정보를 가지고 옴
		String signatureStr = joinPoint.getSignature().toShortString();
//		공통기능 실행(advice) :핵심기능이 start 되었다.
		System.out.println("@@@### start====>"+signatureStr);
		Object obj =null;

		try {
//			핵심기능 실행
			obj = joinPoint.proceed();//예외처리 추가
			return obj;
		}finally {
//		공통기능 실행(advice)
			System.out.println("@@@### end====>"+signatureStr);
		}
	}
}
