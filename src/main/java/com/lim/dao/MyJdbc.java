package com.lim.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lim.entity.Emp;
/**
 *  SpringJdbc详解
 *  @author Root
 */
public class MyJdbc extends JdbcDaoSupport { //JdbcDaoSupport是Spring提供的JDBC支持
	
	 
	/**
	 * 添加对象
	 * @param emp 要添加的对象
	 * @throws Exception
	 */
	public void save(Emp emp)throws Exception{
		//要执行的SQL语句
		String sql="insert into emp1(id,name,password,email,birthday,info)values(?,?,?,?,?,?)";
		//SQL语句中的参数
		Object args[]={emp.getId(),emp.getName(),emp.getPassword(),emp.getEmail(),emp.getBirthday(),emp.getInfo()};
		//SQL语句中的参数类型
		int argTypes[]={Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR};
		//执行添加操作，返回影响行数
		//this.getJdbcTemplate().update(sql); //直接操作SQL语句
		//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
		this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型
	}
	
	/**
	 * 修改对象
	 * @param emp 要修改的对象
	 * @throws Exception
	 */
	public void update(Emp emp)throws Exception{
		//要执行的SQL语句
		String sql="update emp set name=?,password=?,email=?,birthday=?,info=? where id=?";
		//SQL语句中的参数
		Object args[]={emp.getName(),emp.getPassword(),emp.getEmail(),emp.getBirthday(),emp.getInfo(),emp.getId()};
		//SQL语句中的参数类型
		int argTypes[]={Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.INTEGER};
		//执行修改操作，返回影响行数
		//this.getJdbcTemplate().update(sql); //直接操作SQL语句
		//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
		this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型
	}
	
	/**
	 * 删除对象
	 * @param id 要删除对象的id
	 * @throws Exception
	 */
	public void delete(int id)throws Exception{
		//要执行的SQL语句
		String sql="delete from emp where id=?";
		//SQL语句中的参数
		Object args[]={id};
		//SQL语句中的参数类型
		int argTypes[]={Types.INTEGER};
		//执行删除操作，返回影响行数
		//this.getJdbcTemplate().update(sql); //直接操作SQL语句
		//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
		this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型
	}
	
	/**
	 * 根据id查询
	 * @param id 要查询对象的id
	 * @return 此id对应的对象
	 * @throws Exception
	 */
	public Emp findById(int id)throws Exception{
		//要执行的SQL语句
		String sql="select * from emp where id=?";
		//SQL语句中的参数
		Object args[]={id};
		//使用RowMapper封装查询对象
		RowMapper rowMapper=new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setInfo(rs.getString("info"));
				return emp;
			}
		};
		//执行查询操作，返回List集合
		List list=this.getJdbcTemplate().query(sql, args, rowMapper);
		return list.size()>0?(Emp)list.get(0):null;
	}
	
	/**
	 * 查询全部记录
	 * @return 查询到的记录集合
	 * @throws Exception
	 */
	public List findAll()throws Exception{
		//要执行的SQL语句
		String sql="select * from emp";
		//使用RowMapper封装查询对象
		RowMapper rowMapper=new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setInfo(rs.getString("info"));
				return emp;
			}
		};
		//执行查询操作，返回List集合
		List list=this.getJdbcTemplate().query(sql, rowMapper);
		return list.size()>0?list:null;
	}
	
	/**
	 * 查询总记录数
	 * @return 查询到总记录数
	 * @throws Exception
	 */
	public int findTotalCount()throws Exception{
		//要执行的SQL语句
		String sql="select count(id) from emp";
		//执行查询操作，返回int类型（forInt）
		return this.getJdbcTemplate().queryForInt(sql);   //直接操作SQL语句
		//this.getJdbcTemplate().queryForInt(sql, args);  //操作SQL语句+参数
		//this.getJdbcTemplate().queryForInt(sql, args, argTypes);   //操作SQL语句+参数+参数类型
	}
	
	/**
	 * 无查询条件的分页
	 * @param page 页数
	 * @param line 每页显示的行数
	 * @return 查询到的结果集
	 * @throws Exception
	 */
	public List findByPage(int page,int line)throws Exception{
		//要执行的SQL语句
		String sql="select * from emp limit ?,?";
		//SQL语句中的参数
		Object args[]={(page-1)*line,line};
		//使用RowMapper封装查询对象
		RowMapper rowMapper=new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setInfo(rs.getString("info"));
				return emp;
			}
		};
		//执行查询操作，返回List集合
		List list=this.getJdbcTemplate().query(sql, args, rowMapper);
		return list.size()>0?list:null;
	}
	
	/**
	 * 有查询条件的分页
	 * @param page 页数
	 * @param line 每页显示的行数
	 * @param emp 用对象封装查询条件
	 * @return 查询到的结果集
	 * @throws Exception
	 */
	public List findByPage(int page,int line,Emp emp)throws Exception{
		//要执行的SQL语句
		StringBuilder sql=new StringBuilder(" select * from emp1 e where 1=1 ");
		if(emp!=null){
			if(emp.getName()!=null){
				sql.append(" and e.name='"+emp.getName()+"'");
			}
			if(emp.getPassword()!=null){
				sql.append(" and e.password='"+emp.getPassword()+"'");
			}
			if(emp.getEmail()!=null){
				sql.append(" and e.email='"+emp.getEmail()+"'");
			}
			if(emp.getBirthday()!=null){
				sql.append(" and e.birthday=to_date('"+emp.getBirthday()+"','yyyy-mm-dd hh24-mi-ss') ");
			}
			if(emp.getInfo()!=null){
				sql.append(" and e.info='"+emp.getInfo()+"'");
			}
		}
		/*sql.append(" limit ?,? ");
		//输出SQL到控制台
		System.out.println("sql:"+sql);
		//SQL语句中的参数
		Object args[]={(page-1)*line,line};*/
		//使用RowMapper封装查询对象
		RowMapper rowMapper=new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setEmail(rs.getString("email"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setInfo(rs.getString("info"));
				return emp;
			}
		};
		//执行查询操作，返回List集合
		List list=this.getJdbcTemplate().query(sql.toString(), rowMapper); //sql.toString()要转型
		return list.size()>0?list:null;
	}
}
