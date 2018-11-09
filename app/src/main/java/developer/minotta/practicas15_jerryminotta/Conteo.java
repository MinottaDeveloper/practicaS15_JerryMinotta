package developer.minotta.practicas15_jerryminotta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Conteo extends AppCompatActivity {

    Button btn_duque, btn_maltrato;
    TextView tv_cantDuque, tv_cantMaltrato;
    FirebaseDatabase firebaseDatabase;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo);


        btn_duque= findViewById(R.id.btn_duque);
        btn_maltrato= findViewById(R.id.btn_animales);


        tv_cantDuque= findViewById(R.id.tv_cantDuque);
        tv_cantMaltrato= findViewById(R.id.tv_cantMaltrato);

        firebaseDatabase= FirebaseDatabase.getInstance();


        btn_maltrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseDatabase.getReference().child("firmas").child("perticion1").push().setValue("f");


            }
        });


        btn_duque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseDatabase.getReference().child("firmas").child("perticion2").push().setValue("f");

            }
        });


        firebaseDatabase.getReference().child("firmas").child("peticion1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firmas = "FIRMAS: "+ dataSnapshot.getChildrenCount();

                tv_cantMaltrato.setText(firmas);

                for (DataSnapshot dato: dataSnapshot.getChildren()){
                    Log.e("CLAVE", ""+ dato.getKey());
                    Log.e("Descripcion", ""+dato.getValue());

                    String valor = dato.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        firebaseDatabase.getReference().child("firmas").child("peticion2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firmas = "FIRMAS: "+ dataSnapshot.getChildrenCount();

                tv_cantDuque.setText(firmas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
