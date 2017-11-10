package rafaellehnbatista.com.br.provasemestral;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 10/11/2017.
 */

public interface StarWarsService {
    @GET("/api/people/{iddopersonagem}")
    Call<StarWars> buscarStarWars(
            @Path(value = "iddopersonagem") String iddopersonagem);
}
