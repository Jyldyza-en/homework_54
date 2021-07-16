package kg.tutorialapp.homework_54

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Department(
    @PrimaryKey(autoGenerate = false)
    val departmentId: Long,
    val departmentName: String

)
