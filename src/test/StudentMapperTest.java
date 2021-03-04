import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
public class StudentMapperTest {
    @Test
    public void delete(){
        //1.获得操作对象SqlSession，等同于jdbc中的preparestatment对象
        SqlSession session = MybatisUtils.getSqlSession();
        //2.获得操作接口的动态对象
        StudentDao studentMapper = session.getMapper(StudentDao.class);
        Student student=new Student();
        student.setStuId(4);
        student.setStuName("云大琛");
        student.setStuAge(18);
        int count = studentMapper.update(student);


        //        studentMapper.delete(3);
//        student.setStuName("周七");
//        student.setStuAge(55);
        //3.插入对象
        int count2 = studentMapper.update(student);
        //4.提交事务
        session.commit();
        //5.关闭
        session.close();
        System.out.println("修改成功");
        System.out.println("修改成功的数量"+count2);
//        System.out.println("添加成功的数据数量："+count);
//        //需求：实现ID回填，就是插入数据后要将数据库的ID设置在实体类对象里面
//        System.out.println("ID："+student.getStuId());
//        System.out.println("删除成功");
    }
    @Test
    public void findAll() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentDao studentMapper = session.getMapper(StudentDao.class);
        List<Student> list = studentMapper.findAll();
        System.out.println(list.size());
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getStuName());
//            System.out.println(list.get(i).getStuAge());
//        }
//        list.stream().forEach(n->{
//            System.out.println(n.getStuName());
//            System.out.println(n.getStuAge());
//        });
        for (Student s:list){
            System.out.println();
            System.out.println(s.getStuName());
            System.out.println(s.getStuAge());
        }
        session.commit();
        session.close();
    }
}
