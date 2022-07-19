import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("\u001b[1m Bem-vindo! O que vamos assistir hoje? \u001b[0m");

    // checar se a pasta de saída existe, se não existir, criar a pasta
    String fileName = "sticker";
        Path path = Paths.get(fileName);
    
        if (!Files.exists(path)) {
            Files.createDirectory(path);
            System.out.println("Pasta não existe! Criando pasta: "+fileName);
            } else {        
                System.out.println("Pasta já existe!");
            }

    
    // Pegar os dados do banco de dados do Imdb com http
    
    // Top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/"; - correção devido à instabilidade na API original
        //    URI endereço = URI.create(url + APIKey.Chave); - correção devido à instabilidade na API original
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
            URI endereço = URI.create(url);
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(endereço).GET().build();
                HttpResponse<String> resposta =client.send(request, BodyHandlers.ofString());
                    String retorno = resposta.body();
                
    // Melhores séries
    //    String url2 = "https://imdb-api.com/en/API/MostPopularTVs/"; - correção devido à instabilidade na API original
    //    URI endereço2 = URI.create(url2 + APIKey.Chave); - correção devido à instabilidade na API original
        String url2 = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/MostPopularTVs.json";
        URI endereço2 = URI.create(url2);
                request = HttpRequest.newBuilder(endereço2).GET().build();
                HttpResponse<String> resposta2 = client.send(request, BodyHandlers.ofString());
                    String  retorno2 = resposta2.body();
                
    // Tratar os dados vindos do site por Json (título, poster, classificação)
     JsonParser parser = new JsonParser();
        List<Map<String, String>> Lista = parser.parse(retorno);
        List<Map<String, String>> Lista2 = parser.parse(retorno2);
    
    // Visualização dos dados obtidos pelo site
        var stickermaker = new StickerMaker();

            for (Map<String,String> filme : Lista) {

                String linkfilme = filme.get("image");
                InputStream inputfilme = new URL(linkfilme).openStream();
                String nomefilmeraw = (filme.get("title")+".png");
                String nomefilme = nomefilmeraw.replace(":", " -");
                System.out.println(nomefilme);
            
                stickermaker.generate(inputfilme, nomefilme);

                System.out.println("\u001b[1m Nome: " + filme.get("title")+ " \u001b[0m");
                System.out.println("\u001b[3m Pôster: " + filme.get("image")); //+ "\u001b[0m");
                System.out.println("\u001b[45m Nota imDb: " + filme.get("imDbRating")+ "⭐" + "\u001b[0m");
                System.out.println();
        }
                for (Map<String,String> serie : Lista2) {
                    
                    String linkserie = serie.get("image");
                    InputStream inputserie = new URL(linkserie).openStream();
                    String nomeserieraw = (serie.get("title")+ ".png");
                    String nomeserie = nomeserieraw.replace(":", " -");
                    stickermaker.generate(inputserie, nomeserie);

                    System.out.println("\u001b[1m Nome:" + serie.get("title") + "\u001b[0m");
                    System.out.println("\u001b[3m Pôster:" + serie.get("image")); // + "\u001b[0m");
                    System.out.println("\u001b[45m Nota imDb:" + serie.get("imDbRating")+ "⭐" +  "\u001b[0m");
                    System.out.println();
                }

    // Exportar os dados como Stickers pra Wpp, Telegram

    
    
    }


}
