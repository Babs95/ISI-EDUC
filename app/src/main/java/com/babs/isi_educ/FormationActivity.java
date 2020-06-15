package com.babs.isi_educ;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FormationActivity extends Fragment {

    private String [] tabFormation, tabDetails;
    private String formation, details;
    private ListView listFormation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formation_activity, container, false);

        listFormation = view.findViewById(R.id.listFormation);
        tabFormation =  getResources().getStringArray(R.array.tab_formation);
        tabDetails =  getResources().getStringArray(R.array.tab_details);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabFormation);
        listFormation.setAdapter(adapter);//chargement des données dans la liste

        //Ici on gàre le clique sur un élèment de la liste
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                formation = tabFormation[position];
                details = tabDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(formation);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.cancel), null);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

            }
        });
        return view;
    }
}
