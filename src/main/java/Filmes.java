import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Filmes extends ListenerAdapter {

    String sinopse;
    String[] mensagemRecebida;
    String sinopsePega;
    String nomeFilme;
    String imagemLink;
    String trailerLink;

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        mensagemRecebida = e.getMessage().getContentRaw().split(" ");
        if(mensagemRecebida[0].equals("+filme"))
        {
            pegarSinopse(mensagemRecebida[1]);
            //pegarTrailer(mensagemRecebida[1]);
            pegarImagem(mensagemRecebida[1]);
            e.getChannel().sendMessage(telaInformacao()).queue();
        }
    }

    public void pegarSinopse(String nomeFilme)
    {
        String url = "https://www.google.com/search?q=";
        String fimURL = "&num=20";

        try{
            final Document document = Jsoup.connect(url+nomeFilme+fimURL).get();
            Elements temp = document.select("div.kno-rdesc");
            int i = 0;
            for(Element filmesinopse:temp)
            {
                i++;
                sinopsePega = (filmesinopse.getElementsByTag("span").first().text());
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
    public void pegarTrailer(String nomeFilme) {
        String url = "https://www.youtube.com/results?search_query=";

        try{




        }catch (Exception exception){
            exception.printStackTrace();
        }


    }
    */

    public void pegarImagem(String nomeFilme)
    {
        String url = "https://www.imdb.com/find?q=";
        String urlFim = "&ref_=nv_sr_sm";

        try{

            final Document document = Jsoup.connect(url+nomeFilme).get();
            Elements temp = document.select("div.article");
            int i = 0;
            for(Element filmeimagem:temp) {
                i++;
                imagemLink = (filmeimagem.getElementsByTag("img").first().attr("src"));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public MessageEmbed telaInformacao () {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setThumbnail(imagemLink);
        embedBuilder.setTitle("Sinopse Filme");
        embedBuilder.addField(" ",sinopsePega+"\n",true);


        return embedBuilder.build();
    }

}
