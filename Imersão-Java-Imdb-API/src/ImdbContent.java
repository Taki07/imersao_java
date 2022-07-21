public class ImdbContent {
    
    private final String titleimdb;
    private final String imgimdb;
    private final String rating;
    
    
    
    
    public ImdbContent(String titulo, String urlimagem, String rate) {
        this.titleimdb = titulo;
        this.imgimdb = urlimagem;
        this.rating = rate;
    }
    
    
    
    
    public String getTitulo() {
        return titleimdb;
    }
    public String getUrlimagem() {
        return imgimdb;
    }
    
    public String getRating(){
        return rating;
    }


}
