package com.furkan.studyjam.besbesteci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout bachLayout = (RelativeLayout) findViewById(R.id.bach_layout);
        RelativeLayout beethovenLayout = (RelativeLayout) findViewById(R.id.beethoven_layout);
        RelativeLayout mozartLayout = (RelativeLayout) findViewById(R.id.mozart_layout);
        RelativeLayout wagnerLayout = (RelativeLayout) findViewById(R.id.wagner_layout);
        RelativeLayout vivaldiLayout = (RelativeLayout) findViewById(R.id.vivaldi_layout);

        bachLayout.setOnClickListener(this);
        beethovenLayout.setOnClickListener(this);
        mozartLayout.setOnClickListener(this);
        wagnerLayout.setOnClickListener(this);
        vivaldiLayout.setOnClickListener(this);

    }

    public void open(String detail, String title, int audioId, String pieceName, int imageId){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("detail", detail);
        intent.putExtra("title", title);
        intent.putExtra("audioId", audioId);
        intent.putExtra("pieceName", pieceName);
        intent.putExtra("imageId", imageId);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bach_layout:
                String bachDetail = "Barok dönem bestecisi.\n(21 Mart 1685, Eisenach - 28 Temmuz 1750, Leipzig)";
                open(bachDetail, "Johann Sebastian Bach", R.raw.bach, "Concerto No. 5 in D major, BWV 1050", R.drawable.bach);
                break;
            case R.id.beethoven_layout:
                String beethovenDetail = "Klasik/romantik dönem bestecisi.\n(17 Aralık 1770, Bonn - 26 Mart 1827, Viyana)";
                open(beethovenDetail, "Ludwig van Beethoven", R.raw.beethoven, "Piano Sonata No. 14 in C sharp minor 'Moonlight', Op. 27-2", R.drawable.beethoven);
                break;
            case R.id.mozart_layout:
                String mozartDetail = "Klasik dönem bestecisi.\n(27 Ocak 1756, Salzburg - 5 Aralık 1791, Viyana)";
                open(mozartDetail, "Wolfgang Amadeus Mozart", R.raw.mozart, "Serenade No. 13 for strings in G major 'Eine kleine Nachtmusik', K.525", R.drawable.mozart);
                break;
            case R.id.wagner_layout:
                String wagnerDetail = "Opera bestecisi, tiyatro direktörü, müzik teoricisi ve yazarı.\n(22 Mayıs 1813, Leipzig – 13 Şubat 1883, Venedik)";
                open(wagnerDetail, "Richard Wagner", R.raw.wagner , "Die Walküre (The Valkyrie), WWV 86B, Act 3", R.drawable.wagner);
                break;
            case R.id.vivaldi_layout:
                String vivaldiDetail = "Barok dönem bestecisi, keman virtüözü.\n(4 Mart 1678, Venedik - 28 Temmuz 1741, Viyana)";
                open(vivaldiDetail, "Antonio Vivaldi", R.raw.vivaldi , "Concerto No. 2 in G minor, Op. 8, RV 315, 'L'estate' (Summer), 3rd Movement", R.drawable.vivaldi);
                break;
        }
    }
}
