package com.ly.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



public class PoolUtil {

    /**实例化连接池
     * @author 快乐小码农
     */
    private static DruidDataSource dataSource;

    static {
        //读取配置文件信息
        InputStream inputStream = PoolUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //实例化解析工具
        Properties properties = new Properties();
        //将输入流放入解析工具解析
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("加载jdbc配置文件失败");
            e.printStackTrace();
        }
//        //将解析后的配置文件放入工厂
//        try {
//            dataSource= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //初始化连接池对象
        dataSource = new DruidDataSource();
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));

    }

    /**
     * @return
     * 通过连接池获取对象
     */
    public static Connection getConner(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
