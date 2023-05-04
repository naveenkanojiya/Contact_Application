package com.example.contactapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModal> arrContacts =new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView =findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number= "";

                        if (!edtName.getText().toString().equals("")){
                            name = edtName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Please enter Contact Name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals("")){
                            number =edtNumber.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModal(R.drawable.man,name,number));

                        if (adapter != null){
                            adapter.notifyItemInserted(arrContacts.size()-1);
                        }else {
                            adapter = new RecyclerContactAdapter(MainActivity.this,arrContacts);
                            recyclerView.setAdapter(adapter);

                        }
                        recyclerView.scrollToPosition(arrContacts.size()-1);

                        dialog.dismiss();



                    }
                });
                dialog.show();

            }
        });






        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModal(R.drawable.a,"Aman","9864839323"));
        arrContacts.add(new ContactModal(R.drawable.b,"Ayush","9864835422"));
        arrContacts.add(new ContactModal(R.drawable.c,"Vishal","9864835454"));
        arrContacts.add(new ContactModal(R.drawable.boy,"Anupam","9986483443"));
        arrContacts.add(new ContactModal(R.drawable.e,"Kuldeep","8648392343"));
        arrContacts.add(new ContactModal(R.drawable.farmer,"Yuvraj","7334393232"));
        arrContacts.add(new ContactModal(R.drawable.man,"Nitin","8642342323"));
        arrContacts.add(new ContactModal(R.drawable.e,"Shailja","9864823443"));
        arrContacts.add(new ContactModal(R.drawable.a,"Nand","9864445523"));
        arrContacts.add(new ContactModal(R.drawable.b,"Krishna","8864856775"));
        arrContacts.add(new ContactModal(R.drawable.man,"Sidharth","7364898772"));
        arrContacts.add(new ContactModal(R.drawable.c,"Shivam","8964839676"));
        arrContacts.add(new ContactModal(R.drawable.boy,"Mandeep","7864567672"));
        arrContacts.add(new ContactModal(R.drawable.a,"Naveen","9864898777"));
        arrContacts.add(new ContactModal(R.drawable.e,"Ram jii","7864835645"));
        arrContacts.add(new ContactModal(R.drawable.man,"Nitesh","9764566562"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);

    }
}