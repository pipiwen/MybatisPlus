package com.syw.mp1.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * MybatisPlus会默认使用实体类名去数据库中找对应表名
 */
@Data
@TableName(value = "employee")
public class Employee {
    /*@TableId(value = "id",type = IdType.UUID)//value:指定表中列名的主键 一致是可以省略，type生成主键的类型*/
    private String id;
    @TableField(value = "last_name",exist = true)//数据库列和属性字段匹配注解方式 exit判断属性是否在数据库中存在
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
}
