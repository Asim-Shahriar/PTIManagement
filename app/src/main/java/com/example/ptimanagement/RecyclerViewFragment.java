package com.example.ptimanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RecyclerViewFragment extends Fragment implements RecyclerViewClickInterface{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        MyListData[] myListData = new MyListData[] {
                new MyListData("About us"),
                new MyListData("Services"),
                new MyListData("E-Services"),
                new MyListData("Contact"),
                new MyListData("Attendance"),
                new MyListData("Result"),
                new MyListData("Notice Board"),
                new MyListData("Notifications"),
                new MyListData("Setting"),

        };

        RecyclerView recyclerView = (RecyclerView)v. findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onItemClick(int position) {
       if(position==0){
           getFragmentManager().beginTransaction().replace(R.id.frameContainer,new AboutUsFragment())
                   .addToBackStack(null).commit();
       }
    }

    @Override
    public void onLongItemClick(int position) {

    }
}