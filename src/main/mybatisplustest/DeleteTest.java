import com.syw.mp1.entity.Employee;
import com.syw.mp1.entity.dao.EmployeeDao;
import com.syw.mpgenerator.dao.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteTest {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private UserMapper userMapper=ioc.getBean("userMapper",UserMapper.class);

    /**
     * 逻辑删除测试
     * @throws Exception
     */
    @Test
    public void test2()throws Exception{
    userMapper.deleteById("1");
    }
}
