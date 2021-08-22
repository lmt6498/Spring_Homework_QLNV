package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_Br;
    private String name_Br;
    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Branch() {
    }

    public Branch(String name_Br) {
        this.name_Br = name_Br;
    }

    public Integer getId_Br() {
        return id_Br;
    }

    public void setId_Br(Integer id_Br) {
        this.id_Br = id_Br;
    }

    public String getName_Br() {
        return name_Br;
    }

    public void setName_Br(String name_Br) {
        this.name_Br = name_Br;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
