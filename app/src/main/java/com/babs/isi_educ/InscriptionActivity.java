package com.babs.isi_educ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {
    private EditText txtFirstName, txtLastName;
    private CheckBox cbOLevel, cbBachelor, cbMaster;
    private Button btnSave;
    private  String firstname, lastname, degrees, formation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        cbOLevel = findViewById(R.id.cbOLevel);
        cbBachelor = findViewById(R.id.cbBachelor);
        cbMaster = findViewById(R.id.cbMaster);
        btnSave = findViewById(R.id.btnSave);
        //Ici on récupère la formation que l'on passe lors de la navigation
        formation = getIntent().getStringExtra("FORMATION");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = txtFirstName.getText().toString().trim();
                lastname = txtLastName.getText().toString().trim();
                degrees = "";

                if (cbOLevel.isChecked()) {
                    degrees+= cbOLevel.getText().toString().trim()+"";
                }
                if (cbBachelor.isChecked()) {
                    degrees+= cbBachelor.getText().toString().trim()+"";
                }
                if (cbMaster.isChecked()) {
                    degrees+= cbMaster.getText().toString().trim()+"";
                }
                String resume = firstname+"\n\n"+lastname+"\n\n"+degrees+"\n\n"+formation;
                EraseFields();
                Toast.makeText(InscriptionActivity.this, resume, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Cette fonction permet de vider les champs de saisies
     * et de décocher les checkbox
     */
    private void EraseFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        //Ici on vérifie d'abord si le checkbox est déjà cocher avant de le décocher
        if (cbOLevel.isChecked()) {
            cbOLevel.setChecked(false);
        }
        if (cbBachelor.isChecked()) {
            cbBachelor.setChecked(false);
        }
        if (cbMaster.isChecked()) {
            cbMaster.setChecked(false);
        }


    }
}
