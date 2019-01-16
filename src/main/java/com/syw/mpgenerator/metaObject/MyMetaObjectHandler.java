package com.syw.mpgenerator.metaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;

public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
      Object fieldValue= getFieldValByName("createDate",metaObject);
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String current=sdf.format(date);
        System.out.println("=========自动插入=========");
      setFieldValByName("createDate",current,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue= getFieldValByName("createDate",metaObject);
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current=sdf.format(date);
        System.out.println("=========自动插入=========");
        setFieldValByName("createDate","current",metaObject);
    }
}
