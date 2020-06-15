package com.babs.isi_educ;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UniversityActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_university, container, false);
        //setContentView(R.layout.activity_university);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in ISI MERE and move the camera
        LatLng isiMere = new LatLng(14.706603, -17.461203);
        mMap.addMarker(new MarkerOptions().position(isiMere).title("Marker in ISI Mère")
                .snippet("Contact: ++221338221981, Email: isi.sn"));


        LatLng isiFass = new LatLng(14.701101, -17.451972);
        mMap.addMarker(new MarkerOptions().position(isiFass).title("Marker in ISI FASS")
        .snippet("Contact: +221338224178, Email: isi.sn")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng isiKeurMassar= new LatLng(14.812503, -17.288171);
        mMap.addMarker(new MarkerOptions().position(isiKeurMassar).title("Marker in ISI Keur Masssar")
                .snippet("Contact: +221338784349, Email: isi.sn, Site:http://www.groupeisi.com/"));

        //Ici on creer un cercle avec comme centre(point de départ) Isi Mère
        CircleOptions circleOptions = new CircleOptions()
                .center(isiMere)
                .radius(500)
                .fillColor(Color.GREEN)
                .strokeColor(Color.BLUE)
                .strokeColor(5);

        //Ici on ajoute le cercle au niveau de la carte
        mMap.addCircle(circleOptions);

        //mMap.setMapType();

        //Ici on dit à la camera de se fixer sur ISI Mere en faisant un zoom de 12
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(isiMere, 12));
    }
}
