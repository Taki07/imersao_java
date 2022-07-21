import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractor {
    
public List<NasaContent> extractcontentnasa(String json){

    JsonParser parser = new JsonParser();
    List<Map<String, String>> jsoncontent = parser.parse(json);

        List<NasaContent> content = new ArrayList<>();
            for (Map<String, String> atributes : jsoncontent) {
                String title = atributes.get("title");
                String date = atributes.get("date");
                String hdurl = atributes.get("url");
            
                    var conteudos = new NasaContent(title, hdurl, date);        
                    content.add(conteudos);
            }

    return content;
}

public List<ImdbContent> extractcontentimdb(String json){

    JsonParser parser = new JsonParser();
    List<Map<String,String>> jsoncontent = parser.parse(json);

        List<ImdbContent> content = new ArrayList<>();
            for (Map<String,String> atributes : jsoncontent) {
                    String title = atributes.get("title");
                    String url = atributes.get("image");
                    String rating = atributes.get("imDbRating");
                    
                        var conteudos = new ImdbContent(title, url, rating);
                        content.add(conteudos);

            }

return content;
}

}
