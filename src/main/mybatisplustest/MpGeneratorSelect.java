import com.baomidou.mybatisplus.plugins.Page;
import com.syw.mpgenerator.dao.EmployeeMapper;
import com.syw.mpgenerator.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MpGeneratorSelect {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeMapper employeeMapper =ioc.getBean("employeeMapper", EmployeeMapper.class);
    //插件实现物理分页
    @Test
    public void test1()throws Exception{
        Page<Employee> page=new Page(1,2);
    List<Employee>emps= employeeMapper.selectPage(page,null);
        System.out.println(emps);
        System.out.println("=====================分页相关信息=====================");
        System.out.println("总条数:"+page.getTotal());
        System.out.println("当前页码:"+page.getCurrent());
        System.out.println("总页码:"+page.getPages());
        System.out.println("每页显示条数:"+page.getSize());
        System.out.println("是否有上一页:"+page.hasPrevious());
        System.out.println("是否有下一页:"+page.hasNext());
        page.setRecords(emps);//将查询结果放入Page对象
    }
}
