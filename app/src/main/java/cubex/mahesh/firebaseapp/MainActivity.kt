package cubex.mahesh.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {

    var et1:EditText? = null
    var et2:EditText? =null

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.editText)
        et2= findViewById(R.id.editText2)

        mAuth = FirebaseAuth.getInstance();

    }

    fun login(v:View){

   mAuth?.signInWithEmailAndPassword(et1?.text.toString(),
                        et2?.text.toString())?.addOnCompleteListener(this,
           object : OnCompleteListener<AuthResult> {
               override fun onComplete(task: Task<AuthResult>) {

                   if(task.isSuccessful){
                       Toast.makeText(this@MainActivity,
                               "Authentication is Success",Toast.LENGTH_LONG).show()

                       startActivity(Intent(this@MainActivity,
                               DashboardActivity::class.java))


                   }else{
                       Toast.makeText(this@MainActivity,
                               "Authentication is Fail",Toast.LENGTH_LONG).show()

                   }

               }
           })


    }
    fun register(v:View){

        mAuth?.createUserWithEmailAndPassword(et1?.text.toString(),et2?.text.toString())?.
                addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
            override fun onComplete(task: Task<AuthResult>) {

                if(task.isSuccessful){
                Toast.makeText(this@MainActivity,
                        "Authentication is Success",Toast.LENGTH_LONG).show()
    startActivity(Intent(this@MainActivity,RegisterActivity::class.java))
                }else{
                    Toast.makeText(this@MainActivity,
                            "Authentication is Fail",Toast.LENGTH_LONG).show()

                }

            }
        })

    }


}
