package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class RegisterActivity : AppCompatActivity() {

    var et3:EditText? = null
    var et4:EditText? = null
    var et5:EditText? = null
    var et6:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        et3 = findViewById(R.id.editText3)
        et4 = findViewById(R.id.editText4)
        et5 = findViewById(R.id.editText5)
        et6 = findViewById(R.id.editText6)

    }

    fun  register(v:View)
    {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(FirebaseAuth.getInstance().uid)
        myRef.child("name").setValue(et3?.text.toString())
        myRef.child("gender").setValue(et4?.text.toString())
        myRef.child("mno").setValue(et5?.text.toString())
        myRef.child("dob").setValue(et6?.text.toString())

    }
}
