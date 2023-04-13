package ca.collegelacite.evaluation_formative_11_3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WebViewj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        ArrayList<Pokemon> listeDePokemons = Pokemon.lireDonnées(this);

//        int pos = getIntent().getIntExtra("pok", 0);
        Intent intent = getIntent();

        WebView webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(intent.getStringExtra("url"));

        ImageView iv = findViewById(R.id.listItemImageView);
        String uri = "@drawable/" + intent.getStringExtra("img").toLowerCase();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getDrawable(imageResource);
        iv.setImageDrawable(res);

        TextView tvNom = findViewById(R.id.listItemNomTextView);
        tvNom.setText(intent.getStringExtra("title"));

        TextView tvType = findViewById(R.id.listItemTypeTextView);
        tvType.setText(intent.getStringExtra("type"));

        TextView tvDescription = findViewById(R.id.listItemDescTextView);
        tvDescription.setText(intent.getStringExtra("desc"));
    }

}