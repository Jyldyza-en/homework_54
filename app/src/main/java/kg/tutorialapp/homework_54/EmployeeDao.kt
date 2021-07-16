package kg.tutorialapp.homework_54

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Completable


@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDepartment(department: List<Department>):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: List<Employee>):Completable

    /*@Query(
        "SELECT employee.name, employee.salary, department.name AS department_name " +
                "FROM employee, department " +
                "WHERE department.id == employee.department_id"
    )
    fun getEmployeeWithDepartment(): LiveData<List<EmployeeDepartment>>*/
    @Transaction
    @Query("SELECT * FROM department")
    fun getDepartmentsWithEmployees(): LiveData<List<DepartmentWithEmployees>>
}

