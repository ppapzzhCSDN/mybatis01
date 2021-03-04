package dao;

import entity.Student;

import java.util.List;

/**
 * @author zzh
 * @description
 * @date
 */
public interface StudentDao {

    //需求：实现插入数据到student表
//注意：如果是增删改操作，返回的类型必须是int类型
//返回的是操作影响的行数。
    int insert1(Student student);

    int delete(int stuId);

    int update(Student student);

    //    in
    List<Student> findAll();
}
