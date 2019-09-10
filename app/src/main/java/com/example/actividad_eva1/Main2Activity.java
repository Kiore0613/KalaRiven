package com.example.actividad_eva1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.actividad_eva1.Adapters.IComunicaFragments;
import com.example.actividad_eva1.Adapters.Team;

public class Main2Activity extends AppCompatActivity implements ListTeamFragment.OnFragmentInteractionListener,
                                                                    DetailTeamFragment.OnFragmentInteractionListener, IComunicaFragments {

    ListTeamFragment listTeamFragment;
    DetailTeamFragment detailTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        if(findViewById(R.id.content_fragment)!= null){
            if(savedInstanceState!=null){
                return;
            }

            listTeamFragment = new ListTeamFragment();
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.content_fragment, listTeamFragment).commit();
        }


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void sendTeam(Team team) {

        detailTeamFragment = (DetailTeamFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.fragment_detalle);
        if(detailTeamFragment!= null && findViewById(R.id.content_fragment) == null){
            detailTeamFragment.info(team);
        }else {
            detailTeamFragment = new DetailTeamFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("objeto", team);
            detailTeamFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().
                    replace(R.id.content_fragment, detailTeamFragment).addToBackStack(null).commit();
        }
    }
}
