package com.relations.aggregation;

import java.util.ArrayList;
import java.util.List;

public class University
{
    private String name;
    private List<Department> departmentList;

    public University(String name) {
        this.name = name;
        this.departmentList = new ArrayList<Department>();
    }

    public void addDepartment(Department department) {
        this.departmentList.add(department);
    }

    public void removeDepartment(Department department) {
        this.departmentList.remove(department);
    }
}
