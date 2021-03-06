package kg.tutorialapp.homework_54

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class Employee (
    @PrimaryKey(autoGenerate = false)
    var id: Long,
    var name: String,
    var salary: Int,

    @ColumnInfo(name = "department_id")
    var departmentId: Int
)


