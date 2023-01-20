package uz.mohirdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.name= :name")
    List<Employee> findAllName(@Param("name") String name);

    List<Employee> findAllByName(String name);

    @Query(value = "SELECT * from Employee e where e.name= :name", nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);

    List<Employee> findAllByNameLike(String name);
    @Query("select e from Employee e where e.name like :name")
    List<Employee> findAllByNameJPQL(@Param("name") String name);

    @Query(value = "select * from Employee e where e.name like :name", nativeQuery = true)
    List<Employee> findAllByNameNative(@Param("name") String name);

    List<Employee> findAllByNameStartsWith(String name);
    @Query("select e from Employee e where UPPER(e.name) like UPPER(concat('%', :name, '%'))")
    List<Employee> findAllByNameJPq(@Param("name") String name);
    @Query(value = "select * from Employee e where e.name like %:name%", nativeQuery = true)
    List<Employee> findAllByNameNativeS(@Param("name") String name);

    List<Employee> findAllByNameStartsWithOrderByIdAsc(String name);
    @Query("select e from Employee e where UPPER(e.name) like UPPER(concat('%', :name, '%')) order by e.id asc ")
    List<Employee> findAllByNameJPq1(@Param("name") String name);
    @Query(value = "select * from Employee e where e.name like %:name% Order by desc", nativeQuery = true)
    List<Employee> findAllByNameNativeD(@Param("name") String name);
}