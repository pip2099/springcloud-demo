import com.lanhusoft.HelloApplication;
import com.lanhusoft.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2018-08-25
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes =HelloApplication.class)//Application启动类
public class HelloApplicationTest {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() throws InterruptedException {
        for(int i=0;i<1000;i++){
            sinkSender.output().send(MessageBuilder.withPayload("From SinkSender"+i%2).build());
            Thread.sleep(2000);
        }

    }
}
