package com.ly.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * JDBC工具类
 * @author 快乐小码农
 */
public class JdbcUtil {
    /**
     * 操作数据库对象
     */
  private Connection connection ;

  private PreparedStatement preparedStatement;

  private ResultSet resultSet;


    /**
     * 获取链接
     */
  private void getConnection(){ connection = PoolUtil.getConner(); }

    /**
     * @param sql
     * 创建预编译通道
     */
  private void  getPrepared(String sql){
      getConnection();
      try {
          preparedStatement = connection.prepareStatement(sql);
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

    /**
     * @param buff
     * 绑定参数
     */
  public void bangd(Object[]buff){
      if (buff!=null && buff.length > 0){
          for (int i = 0; i < buff.length; i++){
              try {
                  preparedStatement.setObject(i+1,buff[i]);
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }
  }

    /**
     * 关闭资源
     */
  public void coles(){
      if (resultSet!=null){
          try {
              resultSet.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      if (preparedStatement!=null){
          try {
              preparedStatement.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      if (connection!=null){
          try {
              connection.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }

    /**
     * 执行修改语句
     * @param sql
     * @param buff
     * @return
     */
  public boolean update(String sql,Object [] buff){
      getPrepared(sql);
      //绑定参数
      bangd(buff);
      try {
          return  preparedStatement.executeUpdate()>0 ;
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          this.coles();
      }
      return false;
  }
    /**
     * @param sql
     * @param buff
     * @return
     * 查询语句
     */
  public ResultSet select(String sql,Object [] buff){
      getPrepared(sql);
      bangd(buff);
      try {
          return resultSet = preparedStatement.executeQuery();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }

}
