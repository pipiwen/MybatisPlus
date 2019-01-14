import com.baomidou.mybatisplus.plugins.Page;
import com.syw.mp1.entity.Employee;
import com.syw.mp1.entity.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTest {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeDao employeeDao =ioc.getBean("employeeDao",EmployeeDao.class);
    @Test
    public void test1()throws Exception {
           Employee employee= employeeDao.selectById("1");
        System.out.println(employee);
    }

    /**
     * selectOne param位一个实体对象
     * 只能查找一个 否则org.apache.ibatis.exceptions.TooManyResultsException
     * @throws Exception
     */
    @Test
    public void test2()throws Exception{
        Employee employee=new Employee();
        employee.setGender(1);
        employee.setAge(22);
        Employee e= employeeDao.selectOne(employee);
        System.out.println(e);
    }

    /**
     * selectBatchIds
     * @throws Exception
     */
    @Test
    public void test3()throws Exception{
        List<String>list =new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("2");
        List<Employee> list1=employeeDao.selectBatchIds(list);
        for(Employee e:list1){
            System.out.println(e);
        }
    }

    /**
     * selectByMap
     * param: Map
     * Map中key的值位数据库中的列名
     * @throws Exception
     */
  @Test
    public void test4()throws Exception{
      Map<String,Object> map=new HashMap();
      map.put("last_name","tom");
     List<Employee> list=employeeDao.selectByMap(map);
      for (Employee e:list
           ) {
          System.out.println(e);
      }
    }

    /**
     * 分页查询(此分页效果不是很好)
     * Page extends RowBounds(不使用limit而使用内存)
     * 可以使用pageHelper实现物理分页（limit）
     * @throws Exception
     */
    @Test
    public void test5()throws Exception{
    List list=employeeDao.selectPage(new Page<>(2,2),null);
        System.out.println(list);
    }
}
