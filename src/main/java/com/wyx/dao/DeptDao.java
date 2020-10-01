package com.wyx.dao;

import com.wyx.op.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 王院祥
 * @create 2020-10-01-8:55
 */

public interface DeptDao {
    /**c
     * 查询全部
     * @return
     */
    @Select("select*from dept")
     @Results(id="deptResult",value = {
             @Result(id =true,property = "dept_id",column = "dept_id"),
             @Result(property = "dept_name",column = "dept_name")
     })
    List<Dept>selectAll();

    /**
     * 根据id查询
     * @param dept_id
     * @return
     */
    @Select("select * from dept where dept_id=#{dept_id}")
    @ResultMap("deptResult")
     Dept selectOnt(int dept_id);

    /**
     * 添加
     * @param dept
     * @return
     */
    @Insert("insert into dept(dept_name)values(#{dept_name})")
    @ResultMap("deptResult")
    int insert(Dept dept);

    /**
     * 修改
     * @param dept
     * @return
     */

    @Update("update dept set dept_name=#{dept_name} where dept_id=#{dept_id}")
    @ResultMap("deptResult")
    int update(Dept dept);

    /**
     * 删除
     * @param dept_id
     * @return
     */
    @Delete("delete from dept where dept_id=#{dept_id}")
    @ResultMap("deptResult")
    int delete(int dept_id);

}
