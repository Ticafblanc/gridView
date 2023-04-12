package ca.collegelacite.evaluation_formative_11_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WebViewj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        ArrayList<Pokemon> listeDePokemons = Pokemon.lireDonnées(this);

        int pos = getIntent().getIntExtra("pok", 0);

        WebView webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(listeDePokemons.get(pos).getWikiUrl());

        ImageView iv = findViewById(R.id.listItemImageView);
        listeDePokemons.get(pos).intoImageView(iv);

        TextView tvNom = findViewById(R.id.listItemNomTextView);
        tvNom.setText(listeDePokemons.get(pos).getNomFrançais());

        TextView tvType = findViewById(R.id.listItemTypeTextView);
        tvType.setText(listeDePokemons.get(pos).getType());

        TextView tvDescription = findViewById(R.id.listItemDescTextView);
        tvDescription.setText(listeDePokemons.get(pos).getDescription());
    }

}