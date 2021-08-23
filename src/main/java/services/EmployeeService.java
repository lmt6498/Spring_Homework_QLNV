package services;

import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.IEmployeeRepo;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepo employeeRepo;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepo.delete(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAllByName(String name) {
        return employeeRepo.findAllByName(name);
    }
}
