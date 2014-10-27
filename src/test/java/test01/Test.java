package test01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lim.dao.MyJdbc;
import com.lim.dao.TreeDao;
import com.lim.entity.Emp;
public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MyJdbc SpringJdbc = (MyJdbc) ctx.getBean("myJdbc");
		TreeDao SpringJdbc = (TreeDao) ctx.getBean("TreeDao");
		SpringJdbc.getRes("120680095");
		
	/*	// 获取数据源
		System.out.println(SpringJdbc.getMyDataSource());
		// 获取数据库连接
		System.out.println(SpringJdbc.getMyConnection());
		*/
		//添加对象
//		Emp emp=new Emp();
//		emp.setName("spring");
//		emp.setPassword("jdbc");
//		emp.setEmail("123456@qq.com");
//		emp.setBirthday(new Date());
//		emp.setInfo("I love spring");
//		SpringJdbc.save(emp);
		
		//修改对象
//		Emp emp=new Emp();
//		emp.setId(7);
//		emp.setName("spring3.0");
//		emp.setPassword("jdbc3.0");
//		emp.setEmail("123456@163.com");
//		emp.setBirthday(new Date());
//		emp.setInfo("I love spring3.0");
//		SpringJdbc.update(emp);
		
		//删除对象
//		SpringJdbc.delete(7);
		
		//根据id查询
//		System.out.println(SpringJdbc.findById(8).toString());
		
		//查询全部记录集合
//		List list=SpringJdbc.findAll();
//		for(int i=0;i<list.size();i++){
//			Emp emp=(Emp)list.get(i);
//			System.out.println(emp.toString());
//		}
		
		//查询全部记录数
//		System.out.println(SpringJdbc.findTotalCount());
		
		//分页查询（无查询条件）
//		List list=SpringJdbc.findByPage(2, 2);
//		for(int i=0;i<list.size();i++){
//			Emp emp=(Emp)list.get(i);
//			System.out.println(emp.toString());
//		}
		
		//分页查询（有查询条件）
	/*	Emp emp = new Emp();
		emp.setId(44444);
		emp.setName("spring");
		emp.setPassword("jdbc");
		emp.setEmail("123456@qq.com");
		emp.setBirthday(java.sql.Date.valueOf("2011-02-27")); //日期输入的是String，需要转型
		emp.setInfo("I love spring");
		SpringJdbc.save(emp);
		List list = SpringJdbc.findByPage(1, 2, emp);
		for (int i = 0; i < list.size(); i++) {
			Emp e = (Emp) list.get(i);
			System.out.println(e.toString());
		}*/
	}
}
