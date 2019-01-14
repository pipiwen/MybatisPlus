import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.syw.mp1.entity.Employee;
import com.syw.mp1.entity.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class EntityyWrapper {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeDao employeeDao =ioc.getBean("employeeDao",EmployeeDao.class);

    /**
     * EntityWrapper column是数据库列名
     * .between("age",20,22)
     * .eq("gender",1));相当于and
     * @throws Exception
     */
    @Test
    public void test1()throws Exception{
        List<Employee> emps=employeeDao.selectPage(new Page<Employee>(1,2),
                new EntityWrapper<Employee>().between("age",20,22)
                                             .eq("gender",1));
        System.out.println("emps:"+emps);
    }
    @Test
    public void test2()throws Exception{
        List<Employee> emps=employeeDao.selectList(new EntityWrapper<Employee>()
                                                       .eq("gender",0)
                                                       .like("last_name","mp")
                                                       //.or()//(gender = ? AND last_name LIKE ? OR email LIKE ?)
                                                       .orNew()//(gender = ? AND last_name LIKE ?) OR (email LIKE ?)
                                                       .like("email","163")
        );
        System.out.println("emps:-->"+emps);
    }
    @Test
    public void test3()throws Exception{
        Employee employee=new Employee();
        employee.setLastName("tt");
        employee.setAge(36);
    employeeDao.update(employee,new EntityWrapper<Employee>().eq("last_name","tom")
                                                             .eq("age",3));
    }

    @Test
    public void test4()throws Exception{
    List<Employee> emps=employeeDao.selectList(new EntityWrapper<Employee>().eq("gender",0)
                                                        .orderDesc(Arrays.asList(new String[]{"age"}))
                                                        /*.last("desc")//sql 最后拼接*/
    );
        System.out.println("emps:--"+emps);
    }
}
