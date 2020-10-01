package com.wyx.op;

/**
 * @author 王院祥
 * @create 2020-10-01-8:52
 */

public class Dept {
   private int id;
   private String name;

    public Dept(String dept_name) {
        this.name = dept_name;
    }

    public Dept() {
    }

    public Dept(int dept_id, String dept_name) {
        this.id = dept_id;
        this.name = dept_name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" +  + '\'' +
                '}';
    }

    public int getDept_id() {
        return id;
    }

    public void setDept_id(int dept_id) {
        this.id = dept_id;
    }

    public String getDept_name() {
        return name;
    }

    public void setDept_name(String dept_name) {
        this.name = dept_name;
    }
}
