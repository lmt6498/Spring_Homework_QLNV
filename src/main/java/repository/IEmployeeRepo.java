package repository;

import models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface IEmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {
    @Query(value = "select e from Employee e where e.name like concat('%',:name,'%')")
    Iterable<Employee> findAllByName(@Param("name") String name);
}
