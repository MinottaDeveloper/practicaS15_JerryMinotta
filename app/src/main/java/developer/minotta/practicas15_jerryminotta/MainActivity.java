package developer.minotta.practicas15_jerryminotta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();




        firebaseAuth.createUserWithEmailAndPassword("srcristian@gmail.com", "123456789").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){

                String uID= firebaseAuth.getCurrentUser().getUid();

                Usuario user = new Usuario(uID,"Cristian","srcristian@gmail.com","123456789");

                firebaseDatabase.getReference().child("usuarios").child(uID).setValue(user);

                }else{
                Toast.makeText(MainActivity.this, ""+ task.getException(), Toast.LENGTH_SHORT).show();

            }
            }
        });

    }
}
