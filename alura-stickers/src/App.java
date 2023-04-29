import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {     

        // Fazer uma conexão HTTP
        API api = API.Nasa;

        String url = api.getUrl();

        ExtratorDeConteudo extrator = api.getExtrator();

        var http = new ClienteHTTP();
        String json = http.buscaDados(url); 

        var diretorio = new File("saida/");
        diretorio.mkdir();

        // Exibir e manipular os dados

        List<Conteudo> Conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = Conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo().replace(":", "-")  + ".png";
            
            InputStream seloQualidade = new FileInputStream(new File ("Selo/selo.png"));
            String texto_figura = "TOPZERA";
        
            geradora.cria(inputStream, nomeArquivo, texto_figura, seloQualidade);

            System.out.println(conteudo.titulo());
            System.out.println();
        }

    }

}

// Centralizar o texto na figurinha. Confira a resolução do desafio aqui!
// Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes. Confira a resolução do desafio aqui!
// Colocar contorno (outline) no texto da imagem. Confira a resolução do desafio aqui!
// Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha e fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.! Confira a resolução do desafio aqui!