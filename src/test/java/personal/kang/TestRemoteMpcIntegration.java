package personal.kang;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by kang on 2017/6/10.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "classpath:META-INF/spring/app-context.xml",
//        "classpath:META-INF/spring/integration/jms.xml",
//        "classpath:META-INF/spring/integration/spring-int-jms-client.xml",
//        "classpath:META-INF/spring/integration/spring-int-jms-service.xml",
//
//})
public class TestRemoteMpcIntegration {

    private static RemoteMpcObserver remoteMpcObserver;



    @Test
    public void testCtx() {
    }

    @Test
    public void testPlay() throws IOException {

    }

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
                "classpath:META-INF/spring/app-context.xml",
                "classpath:META-INF/spring/integration/jms.xml",
                "classpath:META-INF/spring/integration/spring-int-jms-client.xml",
                "classpath:META-INF/spring/integration/spring-int-jms-service.xml",
        });

        remoteMpcObserver = ctx.getBean(RemoteMpcObserver.class);

        remoteMpcObserver.play();

    }
}
