package context.context;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/circle.xml");
		MyAnnoClass myAnnoClass = applicationContext.getBean(MyAnnoClass.class);
		System.out.println(myAnnoClass);
	}
}
