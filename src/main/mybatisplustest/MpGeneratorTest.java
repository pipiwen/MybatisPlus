import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MpGeneratorTest {
    /**
     * 1.全局配置
     * 2.数据源配置
     * 3.策略配置
     * 4.包名策略配置
     * 5.整合配置
     */
    @Test
    public void test1()throws Exception{
        //1.全局配置
        GlobalConfig config=new GlobalConfig();
        config.setActiveRecord(true)//是否支持AR模式
              .setAuthor("syw")//作者
              .setOutputDir("D:\\GitDownload\\MybatisPlus\\src\\main\\java")//生成路径
              .setFileOverride(true)//是否文件覆盖
              .setIdType(IdType.UUID)//主键策略
              .setServiceName("%sService")//生成的service接口的名称的首字母是否为I
              .setBaseResultMap(true)
              .setBaseColumnList(true);//生成sql片段
        //2.数据源配置
        Properties prop = new Properties();
        //读取属性文件db.properties
        InputStream in = new BufferedInputStream(new FileInputStream("D:\\GitDownload\\MybatisPlus\\src\\main\\resources\\db.properties"));
        prop.load(in);     ///加载属性列表
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                        .setDriverName(prop.getProperty("jdbc.driverClassName"))
                        .setUrl(prop.getProperty("jdbc.url"))
                        .setUsername(prop.getProperty("jdbc.username"))
                        .setPassword(prop.getProperty("jdbc.password"));
        in.close();
        //3.策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setCapitalMode(true)//全局大写
                      .setDbColumnUnderline(true)//表名字段名是否使用下划线
                      .setNaming(NamingStrategy.underline_to_camel)//数据表映射到实体的命名策略
                      .setInclude("employee");//生成的表
        //4.包名策略配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.syw.mpgenerator")
                     .setMapper("dao")
                     .setService("service")
                     .setController("controller")
                     .setEntity("entity")
                     .setXml("mappings");
        //5.整合配置
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                     .setDataSource(dataSourceConfig)
                     .setStrategy(strategyConfig)
                     .setPackageInfo(packageConfig);
        //6.执行
        autoGenerator.execute();
    }
}
