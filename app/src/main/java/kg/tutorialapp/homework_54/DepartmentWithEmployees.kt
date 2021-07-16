package kg.tutorialapp.homework_54

import androidx.room.Embedded
import androidx.room.Relation

data class DepartmentWithEmployees(
    @Embedded val department: Department,
    @Relation(
        parentColumn = "departmentId",
        entityColumn = "department_id"
    )
    val employee: List<Employee>
)
