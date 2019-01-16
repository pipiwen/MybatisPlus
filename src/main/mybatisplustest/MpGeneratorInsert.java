import com.baomidou.mybatisplus.plugins.Page;
import com.syw.mpgenerator.dao.EmployeeMapper;
import com.syw.mpgenerator.dao.UserMapper;
import com.syw.mpgenerator.entity.Employee;
import com.syw.mpgenerator.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MpGeneratorInsert {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeMapper employeeMapper =ioc.getBean("employeeMapper", EmployeeMapper.class);
    private UserMapper userMapper=ioc.getBean("userMapper",UserMapper.class);
    @Test
    public void test1()throws Exception{
      Employee employee=new Employee();
      employee.setLastName("zhouzhou");
      employee.setAge(21);
      employee.setEmail("zz@qq.com");
      employee.setGender("0");
      employeeMapper.insert(employee);
    }
    @Test
    public void test2()throws Exception{
        User user=new User();
        user.setName("testAutoInsert");
        user.setAge(22);
        user.setDelFlag("0");
    userMapper.insert(user);
    }
}
