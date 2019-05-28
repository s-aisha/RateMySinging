package zulfiqar.com.assignment;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbRef ;
    private List<listdata> listViewH;
    private List<listdata> listViewP;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbRef = database.getReference("users");

        recyclerView = (RecyclerView)  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        listViewH = new ArrayList();
        listViewP = new ArrayList();

        listViewP.add(new listdata("Taib","21","2018-09-09"));
        listViewP.add(new listdata("Imran","22","2018-09-09"));
        listViewP.add(new listdata("Shahi","23","2018-09-09"));
        listViewP.add(new listdata("Shaiksha","24","2018-09-09"));
        listViewP.add(new listdata("Yaseen","25","2018-09-09"));
        listViewP.add(new listdata("Salma","26","2018-09-09"));
        listViewP.add(new listdata("Hammad","27","2018-09-09"));
        listViewP.add(new listdata("Fahad","28","2018-09-09"));
        listViewP.add(new listdata("Sabeer","29","2018-09-09"));
        listViewP.add(new listdata("Mahmooda","30","2018-09-09"));


        for(int i = 0 ;i< listViewP.size();i++){

            dbRef.push().setValue(listViewP.get(i)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();

            }
        });

                                                                  }

//
        GetContacts getContacts = new GetContacts();
        getContacts.execute();
    }

    public class GetContacts extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {


            dbRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    listdata contact = dataSnapshot.getValue(listdata.class);
                    listViewH.add(contact);
                    Toast.makeText(getApplicationContext(),""+listViewH,Toast.LENGTH_SHORT);
                    listadaper  listadaper = new listadaper(getApplication(),listViewH);
                    recyclerView.setAdapter(listadaper);
                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            return null ;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }
}
