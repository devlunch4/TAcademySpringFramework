package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " ����");
		//타겟의 메서드가 호출되기 전으 ㅣ시간
		long start = System.currentTimeMillis();		
		try {
			//타겟의 메소드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
			   (finish - start) + " ms");
		}
	}
}
