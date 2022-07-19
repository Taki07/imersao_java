import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class StickerMaker {

    public void generate(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("images/bestmovies_1.jpg"));
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);


        // criar uma nova imagem em memória com transparência e com tamanho novo
        int largura = original.getWidth();
        int altura = original.getHeight();
        //int novaaltura = altura + 200;
        BufferedImage sticker = new BufferedImage(600, 1000, BufferedImage.TRANSLUCENT);
        System.out.println("A imagem tem "+largura+" de largura e "+altura+" de altura");
        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) sticker.createGraphics();
        graphics.drawImage(original, 0, 0, 600,800, null);
        

        // estilizar o texto a ser escrito
        Font fonte = new Font("Impact", Font.PLAIN , 48);
       // graphics.setColor(Color.yellow);
        graphics.setFont(fonte);        
        
        
        

        // escrever algo na nova imagem com uma imagem dando joinha
        InputStream selo = new FileInputStream("images/joinha.png");
        BufferedImage imgselo = ImageIO.read(selo);
        graphics.drawImage(imgselo, 250, 750, null);
        var texto = "Selo Taki de Qualidade";
        graphics.drawString(texto, 70, 970);
        // tentativa de Outline - falhou
        //  TextLayout tl = new TextLayout(texto,fonte,graphics.getFontRenderContext());
        //  Shape shape = tl.getOutline(null);
        //  graphics.setColor(new Color(255,0,0,255));
        // graphics.draw(shape);
        //  graphics.translate(70, 970);

        // escrever a nova imagem em um arquivo na pasta de saída
        
                    ImageIO.write(sticker, "png", new File("sticker/"+nomeArquivo));



    }

    
}
