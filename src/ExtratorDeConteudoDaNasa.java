import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

         // extrair só os dados que interresam (titulo, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> listaDeAtributo = parser.parse(json);

         List<Conteudo> conteudos = new ArrayList<>();

         //popular a lista de conteudos 
         for (Map<String, String> atributos : listaDeAtributo) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
         }
         
         return conteudos;
    }
}

