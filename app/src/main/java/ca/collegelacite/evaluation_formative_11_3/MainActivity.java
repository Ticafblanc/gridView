package ca.collegelacite.evaluation_formative_11_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Données source de l'adaptateur
        ArrayList<Pokemon> listeDePokemons = Pokemon.lireDonnées(this);

        // Créer l'adaptateur et le connecter aux données.
        // Adaptateur faisant le pont entre le ListView et les données.
        AdaptateurPokemon adaptateur = new AdaptateurPokemon(this, listeDePokemons);

        // Connecter le ListView à l'adaptateur.
        GridView lv = findViewById(R.id.gridView);
        lv.setAdapter(adaptateur);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, WebViewj.class);
//                intent.putExtra("pok", position);

                intent.putExtra("img", listeDePokemons.get(position).getDrawable());
                intent.putExtra("title", listeDePokemons.get(position).getNomFrançais());
                intent.putExtra("desc", listeDePokemons.get(position).getDescription());
                intent.putExtra("type", listeDePokemons.get(position).getType());
                intent.putExtra("url", listeDePokemons.get(position).getWikiUrl());
                startActivity(intent);
            }
        });
    }
}