package rafaellehnbatista.com.br.provasemestral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Principal extends AppCompatActivity {

    private EditText etUsarname;
    private TextView tvNome;
    private TextView tvCabelo;
    private TextView tvPele;
    private ImageView ivGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        etUsarname = (EditText) findViewById(R.id.etUsername);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvCabelo = (TextView) findViewById(R.id.tvCabelo);
        tvPele = (TextView) findViewById(R.id.tvPele);
        ivGenero = (ImageView) findViewById(R.id.ivGenero);
    }

    public void pesquisa(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StarWarsService service = retrofit.create(StarWarsService.class);

        service.buscarStarWars(etUsarname.getText().toString())
                .enqueue(new Callback<StarWars>() {
                    @Override
                    public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                        Picasso.with(Principal.this);
                        tvNome.setText(response.body().getNome());
                        tvPele.setText(response.body().getPele());
                        tvCabelo.setText(response.body().getCabelo());
                    }

                    @Override
                    public void onFailure(Call<StarWars> call, Throwable t) {
                        Toast.makeText(Principal.this, "Ocorreu um erro na requisicao",
                                Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
