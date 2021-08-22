package models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-z0-9\\S]+$")
    private String employee_Code;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-z0-9\\S]+$")
    private String name;
    @Min(18)
    private Integer age;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "id_Br")
    private Branch branch;

    public Employee() {
    }

    public Employee(Integer id, String employee_Code, String name, Integer age, Integer salary, Branch branch) {
        this.id = id;
        this.employee_Code = employee_Code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployee_Code() {
        return employee_Code;
    }

    public void setEmployee_Code(String employee_Code) {
        this.employee_Code = employee_Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
