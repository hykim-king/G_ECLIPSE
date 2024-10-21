/**
 * 
 */
module J25 {
	//외부 패키지 사용 : JDK 1.9
	//리플렉션 허용
	opens com.pcwk.ehr.ed02;
	opens com.pcwk.ehr.ed04;
	requires com.google.gson;
	requires org.jsoup;
	requires org.apache.logging.log4j;
	requires org.apache.logging.log4j.core;	
}