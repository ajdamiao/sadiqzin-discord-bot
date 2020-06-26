import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class Sueca extends ListenerAdapter {

    int numeroPlayer = 0;
    int numeroBot = 0;
    String[] jogadores;
    String jogador1;
    String jogador2;

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        try {
            jogadores = e.getMessage().getContentRaw().split(" ");
            if (jogadores[0].equals("+sueca")) {
                jogador1 = jogadores[1];
                jogador2 = jogadores[2];

                numeroAleatorio();
                if (numeroPlayer < numeroBot) {
                    e.getChannel().sendMessage(jogador2Venceu()).queue();
                }
                if (numeroPlayer > numeroBot) {
                    e.getChannel().sendMessage(jogador1Venceu()).queue();
                }
                if (numeroPlayer == numeroBot) {
                    e.getChannel().sendMessage(empate()).queue();
                }
            }
        }catch (IndexOutOfBoundsException ex) {
            if (e.getMessage().getContentRaw().equals("+sueca")) {
                numeroAleatorio();
                if (numeroPlayer < numeroBot) {
                    e.getChannel().sendMessage(botVencedor()).queue();
                }
                if (numeroPlayer > numeroBot) {
                    e.getChannel().sendMessage(playerVencedor()).queue();
                }
                if (numeroPlayer == numeroBot) {
                    e.getChannel().sendMessage(empateplayers()).queue();
                }
            }
        }
    }

   public void numeroAleatorio()
   {
       Random gerador = new Random();

    for(int i = 1; i<11;i++)
    {
        numeroBot = gerador.nextInt(11);
        numeroPlayer = gerador.nextInt(11);
    }
   }


    public MessageEmbed playerVencedor()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", "BOT: " + numeroBot + "\n",true);
        embedBuilder.addField(" ", "PLAYER: " + numeroPlayer,true);
        embedBuilder.setDescription("Player venceu a rodada");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        System.out.println("Player venceu");
        return embedBuilder.build();
    }

    public MessageEmbed botVencedor()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", "BOT: " + numeroBot + "\n",true);
        embedBuilder.addField(" ", "PLAYER: " + numeroPlayer,true);
        embedBuilder.setDescription("Bot venceu a rodada");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        System.out.println("Bot venceu");
        return embedBuilder.build();
    }

    public MessageEmbed empate()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", "BOT: " + numeroBot + "\n",true);
        embedBuilder.addField(" ", "PLAYER: " + numeroPlayer,true);
        embedBuilder.setDescription("EMPATE");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        return embedBuilder.build();
    }

    public MessageEmbed jogador1Venceu()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", jogador1 + ": " + numeroBot + "\n",true);
        embedBuilder.addField(" ", jogador2 + ": " + numeroPlayer,true);
        embedBuilder.setDescription(jogador2 + " venceu a rodada.");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        System.out.println(jogador1 + " venceu");
        return embedBuilder.build();
    }

    public MessageEmbed jogador2Venceu()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", jogador1 + ": " + numeroBot + "\n",true);
        embedBuilder.addField(" ", jogador2 + ": " + numeroPlayer,true);
        embedBuilder.setDescription(jogador1 + " venceu a rodada.");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        System.out.println(jogador2 + " venceu");
        return embedBuilder.build();
    }

    public MessageEmbed empateplayers()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Sueca");
        embedBuilder.addField(" ", jogador1 + numeroBot + "\n",true);
        embedBuilder.addField(" ", jogador2 + numeroPlayer,true);
        embedBuilder.setDescription("EMPATE");
        embedBuilder.setThumbnail("https://blog.megajogos.com.br/wp-content/uploads/2012/01/suecacartas.jpg");
        System.out.println("Empate");
        return embedBuilder.build();
    }

}
