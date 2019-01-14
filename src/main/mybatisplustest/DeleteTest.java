import com.syw.mp1.entity.Employee;
import com.syw.mp1.entity.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteTest {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeDao employeeDao =ioc.getBean("employeeDao",EmployeeDao.class);
    @Test
    public void test1()throws Exception {
        Integer size= employeeDao.deleteById("4");
        System.out.println(size);
    }
}
