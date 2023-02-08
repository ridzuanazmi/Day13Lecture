package ibf2022.ssf.day13.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.ssf.day13.model.Employee;

// functions that deals/stores data

@Repository
public class EmployeeRepo {

    private List<Employee> employees;

    // Constructor with preset employee information
    public EmployeeRepo() throws ParseException {

        if (employees == null) {
            employees = new ArrayList<>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date dt = df.parse("1994-06-04");
        Employee emp = new Employee("Ridzuan", "Azmi", "550 CCk St 52", 680550, "ridzy@gmail.com", "96661277", 66000,
                dt);
        employees.add(emp);

        dt = df.parse("1994-08-23");
        emp = new Employee("Almas Alwani", "Abdul Wahab", "550 CCk St 52", 680550, "almas@gmail.com", "94239204",
                100000,
                dt);
        employees.add(emp);
    }

    // Methods of the repo to modify the data of the list such as add/remove/update
    public List<Employee> findAll() {

        return employees;
    }

    // This method adds the employee and returns true if successful
    public Boolean save(Employee employee) {

        Boolean result = employees.add(employee);
        return result;
    }

    // this method singles out the employee object using the email entered. not a good practise
    public Employee findByEmailId(String email) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(email)).findFirst().get();

        return emp;
    }

    // this method removes the object from the ArrayList. It returns true if successful 
    public Boolean delete(Employee employee) {

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
            result = true;
        }

        return result;
    }

    // This method updates an employee object and returns true if successful
    public Boolean updateEmployee(Employee em) {

        /* 
         * The lambda expression below creates a stream from the list employees, 
         * which is assumed to contain objects of type Employee.
         * 
         * It filters the stream using the filter method, and only keeps those Employee
         * objects for which the result of the e.getEmail().equals(em.getEmail())
         * expression is true. This expression compares the email of the current
         * Employee object e in the stream with the email of another Employee object em.
         * 
         * The findFirst method is then called on the filtered stream, which returns the
         * first Employee object that matches the filter criteria, if there is any.
         * 
         * Finally, the get method is called on the returned Optional object to retrieve
         * the matching Employee object. This method throws a NoSuchElementException if
         * the Optional is empty, i.e. there was no matching Employee object.
         */
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(em.getEmail())).findFirst().get();
        Boolean result = false;
        int employeeIndex = employees.indexOf(emp);

        if (employeeIndex >= 0) {

            // Set or change the fields of the selected employee using the setters
            // The value in the form will set/change the field
            employees.get(employeeIndex).setAddress(em.getAddress());
            employees.get(employeeIndex).setBirthday(em.getBirthday());
            employees.get(employeeIndex).setFirstName(em.getFirstName());
            employees.get(employeeIndex).setLastName(em.getLastName());
            employees.get(employeeIndex).setSalary(em.getSalary());
            employees.get(employeeIndex).setPhoneNo(em.getPhoneNo());
            employees.get(employeeIndex).setPostalCode(em.getPostalCode());
            result = true;
        }

        // employees.add(em);

        return result;
    }
}
