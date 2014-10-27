package com.lim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lim.entity.TSM_FUNCTION;


public class TreeDao extends JdbcDaoSupport {

	public List<TSM_FUNCTION> getRes(String pid) {
		final List<TSM_FUNCTION> list = new ArrayList<TSM_FUNCTION>();
		TSM_FUNCTION ts=new TSM_FUNCTION();
		//使用RowMapper封装查询对象
				RowMapper rowMapper=new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						TSM_FUNCTION emp=new TSM_FUNCTION();
						emp.setFldid(rs.getString("fldid"));
						emp.setFldsfuncname(rs.getString("fldsfuncname"));
						emp.setFldorder(rs.getInt("fldorder"));
						emp.setFldparentid(rs.getString("fldparentid"));
						list.add(emp);
						return null;
					}
				};
			if (pid.equals("root")) {
			 this.getJdbcTemplate().query("select fldid,fldsfuncname,fldorder,fldparentid from tsm_function where fldparentid is null",rowMapper);
			} else {
				Object arg[]={pid};
				this.getJdbcTemplate().query("select fldid,fldsfuncname,fldorder,fldparentid from tsm_function where fldparentid=? ",arg,rowMapper);
				for(TSM_FUNCTION object:list){
					System.out.println(object.toString());
					
				}
				
				
				 
			}
		return list;
	}

	public void addBrother(TSM_FUNCTION fun) throws Exception {
		//要执行的SQL语句
				String sql="insert into tsm_function (fldid,fldsfuncname,fldparentid) values(?,?,?)";
				//SQL语句中的参数
				Object args[]={fun.getFldid(),fun.getFldsfuncname(),fun.getFldparentid()};
				//SQL语句中的参数类型
				int argTypes[]={Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
				//执行修改操作，返回影响行数
				//this.getJdbcTemplate().update(sql); //直接操作SQL语句
				//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
				this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型

	}

	public void delete(String id) throws Exception {
		//要执行的SQL语句
				String sql="delete from tsm_function where fldid=?";
				//SQL语句中的参数
				Object args[]={id};
				//SQL语句中的参数类型
				int argTypes[]={Types.INTEGER};
				//执行删除操作，返回影响行数
				//this.getJdbcTemplate().update(sql); //直接操作SQL语句
				//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
				this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型
	}

	public void update(String id, String text) throws Exception {
		//要执行的SQL语句
		String sql="update tsm_function set FLDSFUNCNAME=? where  fldid= id ";
		//SQL语句中的参数
		Object args[]={text,id};
		//SQL语句中的参数类型
		int argTypes[]={Types.VARCHAR,Types.VARCHAR};
		//执行修改操作，返回影响行数
		//this.getJdbcTemplate().update(sql); //直接操作SQL语句
		//this.getJdbcTemplate().update(sql, args); //操作SQL语句+参数
		this.getJdbcTemplate().update(sql, args, argTypes); //操作SQL语句+参数+参数类型
	}

	public List<String> findPath(String text) {
		final List<String> strList = new ArrayList<String>();
		final ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> paths = new ArrayList<String>();
		
	 
		Object args[]={text};
		this.getJdbcTemplate().queryForList("select fldid from tsm_function where fldsfuncname=? ",args,new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						strList.add(rs.getString("fldid"));
						return null;
					}
		});
		this.getJdbcTemplate().queryForList("select fldid from tsm_function where fldsfuncname=? ",args,new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				strList.add(rs.getString("fldid"));
				return null;
			}
		});
			for (int i = 0; i < strList.size(); i++) {
				Object str[]={strList.get(i)};
				this.getJdbcTemplate().queryForList("select fldid from tsm_function start with fldid= ?  connect by prior fldparentid=fldid ",str,new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						path.add(rs.getString("fldid"));
						return null;
					}
				});
				 
				Collections.reverse(path); // 数组倒置
				System.out.println("path>>>>>>>>>>>>>>>>>>>>>>>>"
						+ path.toString());
				paths.add(path.toString());
				path.clear();
			}
		System.out.println(paths.toString());
		return paths;
	}

	/**
	 * 根据pid查询子集合
	 * 
	 * @param pid
	 * @return list
	 */
	public List<TSM_FUNCTION> querySonList(String pid) {
		final List<TSM_FUNCTION> list = new ArrayList<TSM_FUNCTION>();
		//使用RowMapper封装查询对象
		RowMapper rowMapper=new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						TSM_FUNCTION emp=new TSM_FUNCTION();
						emp.setFldid(rs.getString("fldid"));
						emp.setFldsfuncname(rs.getString("fldsfuncname"));
						emp.setFldorder(rs.getInt("fldorder"));
						emp.setFldparentid(rs.getString("fldparentid"));
						list.add(emp);
						return null;
					}
				};
			if (pid.equals("root")) {
			 this.getJdbcTemplate().query("select fldid,fldsfuncname,fldorder,fldparentid from tsm_function where fldparentid is null",rowMapper);
			} else {
				 this.getJdbcTemplate().query("select fldid,fldsfuncname,fldorder,fldparentid from tsm_function where fldparentid='"
								+ pid + "'",rowMapper);
			}
		return list;
	}

	/**
	 * 根据名字查询菜单
	 * 
	 * @param text
	 * @return List<TSM_FUNCTION>
	 */
	public List<TSM_FUNCTION> findByText(String text) {
		final List<String> strList = new ArrayList<String>();
		final List<TSM_FUNCTION> list = new ArrayList<TSM_FUNCTION>();
		Object args[]={text};
		RowMapper rowMapper=new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				TSM_FUNCTION emp=new TSM_FUNCTION();
				emp.setFldid(rs.getString("fldid"));
				emp.setFldsfuncname(rs.getString("fldsfuncname"));
				emp.setFldorder(rs.getInt("fldorder"));
				emp.setFldparentid(rs.getString("fldparentid"));
				if (!(list.contains(emp))) {
					list.add(emp);
				}
				return emp;
			}};
		this.getJdbcTemplate().queryForList("select fldid from tsm_function where fldsfuncname like'%?%'",args,new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				strList.add(rs.getString("fldid"));
				return null;
			}});
		for (int i = 0; i < strList.size(); i++) {
			Object str[]={strList.get(i)};
			this.getJdbcTemplate().queryForList("select fldid,fldsfuncname,fldorder,fldparentid from tsm_function start with fldid=? connect by prior fldparentid=fldid ",str,rowMapper);
		}
		/*
		 * Set<TSM_FUNCTION> s= new TreeSet<TSM_FUNCTION>(new
		 * Comparator<TSM_FUNCTION>(){
		 * 
		 * public int compare(TSM_FUNCTION o1, TSM_FUNCTION o2) { return
		 * o1.getFldid().compareTo(o2.getFldid()); } }); s.addAll(list);
		 * list.clear(); list.addAll(s);
		 */
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getFldid().equals(list.get(i).getFldid())) {
					list.remove(j);
				}
			}
		}

		for (TSM_FUNCTION obj : list) {
			System.out.println(obj.toString());
		}
		return list;
	}

}