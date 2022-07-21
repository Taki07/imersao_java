import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    
    // Chamar as classes construtoras
        ContentExtractor extractor = new ContentExtractor();
        var http = new ClientHttp();
        var stickermaker = new StickerMaker();
        // Pegar os dados do banco de dados do Imdb com http

    // Top 250 filmes
    //  String topfilmes = "https://imdb-api.com/en/API/Top250Movies/"+APIKey.ChaveimDb; - correção devido à instabilidade na API original
        
        String topfilmes = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
            
    // API Astronomic Picture of the Day - Nasa    
        String nasaApod = "https://api.nasa.gov/planetary/apod?api_key=";
        String argumentsnasa = "&start_date=2022-06-12&end_date=2022-06-14";
        String urlnasa = nasaApod+APIKey.ChaveNasa+argumentsnasa;
                        
    // Melhores séries
    //  String topseries = "https://imdb-api.com/en/API/MostPopularTVs/"+APIKey.ChaveimDb; - correção devido à instabilidade na API original
        String topseries = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/MostPopularTVs.json";
    
        
          

    // Tratar os dados vindos do site por Json (título, poster, classificação)
        
    String nasajson = http.searchData(urlnasa);
    String topfilmesjson = http.searchData(topfilmes);
    String topseriesjson = http.searchData(topseries);
    
    // Visualização dos dados obtidos pelas APIs
        
        List<NasaContent> nasa = extractor.extractcontentnasa(nasajson);
            
        for (int index = 0; index < 3; index++) {
            
            NasaContent nasacontent = nasa.get(index);
            InputStream stream = new URL(nasacontent.getUrlimagem()).openStream();
            String stickernasaraw = nasacontent.getTitulo()+nasacontent.getDate()+".png";
            var stickernasa = stickernasaraw.replace(":", " - ");
            stickermaker.generate(stream, stickernasa);
            System.out.println(nasacontent.getTitulo());
            System.out.println(nasacontent.getDate());
            System.out.println("Gerando foto "+ stickernasa);
        }
    
        List<ImdbContent> imdbfilmes = extractor.extractcontentimdb(topfilmesjson);

        for (int index = 0; index < 3; index++) {

            ImdbContent filmeContent = imdbfilmes.get(index);
            InputStream streamfilme = new URL(filmeContent.getUrlimagem()).openStream();
            String stickerfilmeraw = filmeContent.getTitulo()+ ".png";
            String stickerfilme = stickerfilmeraw.replace(":", " - ");
            stickermaker.generate(streamfilme, stickerfilme);
            System.out.println("\u001b[1m Nome: " + filmeContent.getTitulo()+ " \u001b[0m");
            System.out.println("\u001b[3m Pôster: " + filmeContent.getUrlimagem() + "\u001b[0m");
            System.out.println("\u001b[45m Nota imDb: " + filmeContent.getRating()+ "⭐" + "\u001b[0m");
            System.out.println();           
        }

        List<ImdbContent> imdbseries = extractor.extractcontentimdb(topseriesjson);

        for (int index = 0; index < 3; index++) {

            ImdbContent seriesContent = imdbseries.get(index);
            InputStream streamseries = new URL(seriesContent.getUrlimagem()).openStream();
            String stickerseriesraw = seriesContent.getTitulo()+ ".png";
            String stickerseries = stickerseriesraw.replace(":", " - ");
            stickermaker.generate(streamseries, stickerseries);   
            System.out.println("\u001b[1m Nome:" + seriesContent.getTitulo() + "\u001b[0m");
            System.out.println("\u001b[3m Pôster:" + seriesContent.getUrlimagem() + "\u001b[0m");
            System.out.println("\u001b[45m Nota imDb:" + seriesContent.getRating()+ "⭐" +  "\u001b[0m");
            System.out.println();         
        }
   



                     
                       
                    
    // Exportar os dados como Stickers pra Wpp, Telegram

    
    
    }


}
