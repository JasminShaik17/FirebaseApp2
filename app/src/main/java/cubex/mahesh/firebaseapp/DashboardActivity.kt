package cubex.mahesh.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener



class DashboardActivity : AppCompatActivity() {
    var tv1:TextView?=null
    var tv2:TextView?=null
    var tv3:TextView?=null
    var tv4:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tv1 = findViewById(R.id.textView)
        tv2 = findViewById(R.id.textView2)
        tv3 = findViewById(R.id.textView3)
        tv4 = findViewById(R.id.textView4)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(FirebaseAuth.getInstance().uid)
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

            var it =  dataSnapshot.children;
             it.forEach({
                 if(it.key.equals("name")){
                     tv1?.setText(it.value.toString())
                 }
                 if(it.key.equals("gender")){
                     tv2?.setText(it.value.toString())
                 }
                 if(it.key.equals("mno")){
                     tv3?.setText(it.value.toString())
                 }
                 if(it.key.equals("dob")){
                     tv4?.setText(it.value.toString())
                 }
             })

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}
