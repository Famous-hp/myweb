package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;

// 对象序列化工具
public class SerializeUtil implements ApplicationContextAware{
    private ApplicationContext applicationContext;

	public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
         ByteArrayOutputStream baos = null;
         try {
              // 序列化
             baos = new ByteArrayOutputStream();
             oos = new ObjectOutputStream(baos);
             oos.writeObject(object);
              byte[] bytes = baos.toByteArray();
              return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
   }

   public static Object unserialize( byte[] bytes) {
        ByteArrayInputStream bais = null;
         try {
              // 反序列化
             bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais);
              return ois.readObject();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
   }

   public DataSource getDataSource(){
	    if (applicationContext != null){

        }
        return null;
   }

   public Connection getConn(){
       Connection con = null;
       try{
           DataSource ds = getDataSource();
           if (ds != null){

           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return con;
   }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
