package kg.tutorialapp.homework_54

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = EmployeeDatabase.getInstance(this).employeeDao

        val departments = listOf(
            Department(1, "Back-office"),
            Department(2, "Front-office")
        )

        val employees = listOf(
            Employee(1,"Jyldyz Sultanbekova", 20000,1),
            Employee(2,"Mike Litoris", 15000,1),
            Employee(3,"Jack Goff", 30000,2)
        )

        dao
            .insertEmployee(employee = employees)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  }
        dao
            .insertDepartment(department = departments)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  }


        val employeesLiveData = dao.getEmployeeWithDepartment()

        employeesLiveData.observe(this,
            { TAG = "$it" })

    }


    companion object{
        var TAG = "myLog"
    }
}