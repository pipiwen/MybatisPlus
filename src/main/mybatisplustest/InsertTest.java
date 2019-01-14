import com.syw.mp1.entity.Employee;
import com.syw.mp1.entity.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class InsertTest {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    @Test
    public void test1(){
        DataSource dataSource=ioc.getBean("dataSource",DataSource.class);
        System.out.println("------dataSource:"+dataSource);
    }

    /**
     * Mybatis 会自动将插入的id传回实体的id中
     */
    @Test
    public void test2(){
        EmployeeDao employeeDao=ioc.getBean("employeeDao",EmployeeDao.class);
        Employee employee=new Employee();
                employee.setLastName("mp2");
                employee.setAge(23);
                employee.setEmail("mp1@163.com");
                employee.setGender(1);
        int result= employeeDao.insert(employee);
        System.out.println(result);
        System.out.println(employee.getId());
    }
    @Test
    public void test3()throws Exception{

    }
}
