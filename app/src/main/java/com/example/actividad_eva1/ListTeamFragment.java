package com.example.actividad_eva1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.actividad_eva1.Adapters.IComunicaFragments;
import com.example.actividad_eva1.Adapters.Team;
import com.example.actividad_eva1.Adapters.TeamAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListTeamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTeamFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Team> listTeam;
    RecyclerView reycler;
    Activity activity;
    IComunicaFragments interfaceComunica;

    public ListTeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTeamFragment newInstance(String param1, String param2) {
        ListTeamFragment fragment = new ListTeamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_team, container, false);
        listTeam = new ArrayList<>();
        reycler = view.findViewById(R.id.recyclerview);
        reycler.setLayoutManager(new LinearLayoutManager(getContext()));

        fill();
        TeamAdapter adapter = new TeamAdapter(listTeam);
        reycler.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunica.sendTeam(listTeam.get(reycler.getChildAdapterPosition(v)));
            }
        });


        return view;
    }

    public void fill(){
        listTeam.add(new Team( getResources().getString(R.string.team_athletic_bilbao),  R.drawable.athletic_bilbao, getResources().getString(R.string.athletic_bilbao)));
        listTeam.add(new Team(getResources().getString(R.string.team_atletico_madrid), R.drawable.atletico_madrid,getResources().getString(R.string.atletico_madrid)));
        listTeam.add(new Team(getResources().getString(R.string.team_barcelona), R.drawable.barcelona,getResources().getString(R.string.barcelona)));
        listTeam.add(new Team(getResources().getString(R.string.team_betis), R.drawable.betis,getResources().getString(R.string.betis)));
        listTeam.add(new Team(getResources().getString(R.string.team_celta_vigo), R.drawable.celta_vigo,getResources().getString(R.string.celta_vigo)));
        listTeam.add(new Team(getResources().getString(R.string.team_deportivo), R.drawable.deportivo,getResources().getString(R.string.deportivo)));
        listTeam.add(new Team(getResources().getString(R.string.team_espanyol), R.drawable.espanyol,getResources().getString(R.string.espanyol)));
        listTeam.add(new Team(getResources().getString(R.string.team_getafe), R.drawable.getafe,getResources().getString(R.string.getafe)));
        listTeam.add(new Team(getResources().getString(R.string.team_granada), R.drawable.granada,getResources().getString(R.string.granada)));
        listTeam.add(new Team(getResources().getString(R.string.team_levante), R.drawable.levante,getResources().getString(R.string.levante)));
        listTeam.add(new Team(getResources().getString(R.string.team_malaga), R.drawable.malaga,getResources().getString(R.string.malaga)));
        listTeam.add(new Team(getResources().getString(R.string.team_mallorca), R.drawable.mallorca,getResources().getString(R.string.mallorca)));
        listTeam.add(new Team(getResources().getString(R.string.team_osasuna), R.drawable.osasuna,getResources().getString(R.string.osasuna)));
        listTeam.add(new Team(getResources().getString(R.string.team_real_madrid), R.drawable.real_madrid,getResources().getString(R.string.real_madrid)));
        listTeam.add(new Team(getResources().getString(R.string.team_real_sociedad), R.drawable.real_sociedad,getResources().getString(R.string.real_sociedad)));
        listTeam.add(new Team(getResources().getString(R.string.team_vallecano), R.drawable.rayo_vallecano,getResources().getString(R.string.vallecano)));
        listTeam.add(new Team(getResources().getString(R.string.team_sevilla), R.drawable.sevilla,getResources().getString(R.string.sevilla)));
        listTeam.add(new Team(getResources().getString(R.string.team_valladolid), R.drawable.valladolid,getResources().getString(R.string.valladolid)));
        listTeam.add(new Team(getResources().getString(R.string.team_valencia), R.drawable.valencia,getResources().getString(R.string.valencia)));
        listTeam.add(new Team(getResources().getString(R.string.team_zaragoza), R.drawable.zaragoza,getResources().getString(R.string.zaragoza)));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunica = (IComunicaFragments) this.activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
  public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}


