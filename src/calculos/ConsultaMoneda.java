package calculos;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private static final String API_KEY = "2820b76f5473de5d6627de77";

    public Moneda convertirMoneda(String monedaOrigen, String monedaDestino){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+monedaOrigen+"/"+monedaDestino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(direccion)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró el tipo de cambio");
        }
    }
}
