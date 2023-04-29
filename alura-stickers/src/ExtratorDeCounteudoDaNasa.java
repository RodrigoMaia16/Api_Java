import java.util.List;
import java.util.Map;

public class ExtratorDeCounteudoDaNasa implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos (String json) {
        // Extrair os dados que nos interessam (título, Poster(img), classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listadeAtributos = parser.parse(json);
        
        return listadeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
            .toList();
    }
}
