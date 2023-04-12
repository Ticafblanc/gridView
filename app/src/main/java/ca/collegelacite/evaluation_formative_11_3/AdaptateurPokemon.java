package ca.collegelacite.evaluation_formative_11_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptateurPokemon extends BaseAdapter {
    private Context contexte;
    private LayoutInflater inflater;

    private ArrayList<Pokemon> sourceDonnées;

    public AdaptateurPokemon(Context ctx, ArrayList<Pokemon> données) {
        this.contexte = ctx;
        this.sourceDonnées = données;

        this.inflater = (LayoutInflater)this.contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sourceDonnées.size();
    }

    @Override
    public Object getItem(int i) {
        return sourceDonnées.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.item_list_pokemon, viewGroup, false);

        Pokemon pokemon = sourceDonnées.get(i);

        ImageView iv = rowView.findViewById(R.id.listItemImageView);
        pokemon.intoImageView(iv);

        TextView tvNom = rowView.findViewById(R.id.listItemNomTextView);
        tvNom.setText(pokemon.getNomFrançais());


        return rowView;
    }
}
