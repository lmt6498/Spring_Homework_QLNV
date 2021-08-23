package validate;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import services.IEmployeeService;

public class ValidateEmployeeCode implements Validator {
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Iterable<Employee> list = employeeService.findAll();
        Employee employee = (Employee) target;

        for (Employee e:list) {
            if (e.getEmployee_Code().equals(employee.getEmployee_Code())){
                errors.rejectValue("employee_Code", "employeeCode_Duplicate");
                break;
            }
        }
    }
}
