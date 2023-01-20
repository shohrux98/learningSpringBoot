package uz.mohirdev.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.entity.Employee;
import uz.mohirdev.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Employee> findAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    public List<Employee> findAllName(String name){
        List<Employee> employees = employeeRepository.findAllName(name);
        return employees;
    }
    public List<Employee> findByQueryParam(String name){
        return employeeRepository.findAllByNameStartsWithOrderByIdAsc(name);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
