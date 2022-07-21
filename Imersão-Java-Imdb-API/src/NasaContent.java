
public class NasaContent {
    


private final String title;
private final String imgurl;
private final String date;

public NasaContent(String titulo, String urlimagem, String photodate) {
    this.title = titulo;
    this.imgurl = urlimagem;
    this.date = photodate;
}




public String getTitulo() {
    return title;
}
public String getUrlimagem() {
    return imgurl;
}

public String getDate(){
    return date;
}


}
