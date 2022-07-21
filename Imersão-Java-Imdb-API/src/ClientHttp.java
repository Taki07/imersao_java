import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
    

    public String searchData(String url) {

        try{
        URI endereço = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> resposta = client.send(request, BodyHandlers.ofString());
        String retorno = resposta.body();
        return retorno;

        } catch (IOException | InterruptedException ex){

            throw new RuntimeException(ex);

        }

        
    }

}
