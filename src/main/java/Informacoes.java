import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;

public class Informacoes extends ListenerAdapter {

    Member usuario;
    String nome;
    String avatarURL;
    OnlineStatus status;
    List<Role> roles;
    int ano, mes, dia, hora, minutos, segundos;
    List<Activity> atividade;
    String userError;

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        try {

            if (e.getMessage().getContentRaw().contains("+info")) {
                usuario = e.getMessage().getMentionedMembers().get(0);
                avatarURL = usuario.getUser().getAvatarUrl();
                status = usuario.getOnlineStatus();
                roles = usuario.getRoles();
                nome = usuario.getUser().getAsTag();
                ano = usuario.getTimeJoined().getYear();
                mes = usuario.getTimeJoined().getMonthValue();
                dia = usuario.getTimeJoined().getDayOfMonth();
                hora = usuario.getTimeJoined().getHour();
                minutos = usuario.getTimeJoined().getMinute();
                segundos = usuario.getTimeJoined().getSecond();
                atividade = usuario.getActivities();

                e.getChannel().sendMessage(telaInfoMencao()).queue();
            }
            }catch (IndexOutOfBoundsException ex)
            {
                if(e.getMessage().getContentRaw().equals("+info"))
                {
                    nome = e.getAuthor().getAsTag();
                    avatarURL = e.getAuthor().getAvatarUrl();
                    status = e.getMember().getOnlineStatus();
                    roles = e.getMember().getRoles();
                    ano = e.getMember().getTimeJoined().getYear();
                    mes = e.getMember().getTimeJoined().getMonthValue();
                    dia = e.getMember().getTimeJoined().getDayOfMonth();
                    hora =  e.getMember().getTimeJoined().getHour();
                    minutos =  e.getMember().getTimeJoined().getMinute();
                    segundos =  e.getMember().getTimeJoined().getSecond();
                    atividade = e.getMember().getActivities();

                    e.getChannel().sendMessage(telaInfo()).queue();
                }
            }

        }

    public MessageEmbed telaInfoMencao ()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setThumbnail(avatarURL);
        embedBuilder.setTitle("Informacoes");
        embedBuilder.setDescription("Nome: "  + nome + "\n Status: " + status);
        embedBuilder.addField("Dados:", "\n Data de entrada no server: " + dia + "/" + mes + "/" + ano + "  " + hora + ":" + minutos + ":" + segundos +
                "\n Jogando: " + "\n Cargos: " + roles + "\n", true);
        embedBuilder.addBlankField(true);
        return embedBuilder.build();

    }

    public MessageEmbed telaInfo()
    {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setThumbnail(avatarURL);
        embedBuilder.setTitle("Informacoes");
        embedBuilder.setDescription("Nome: "  + nome + "\n Status: " + status);
        embedBuilder.addField("Dados:", "\n Data de entrada no server: " + dia + "/" + mes + "/" + ano + "  " + hora + ":" + minutos + ":" + segundos +
                "\n Jogando: " + "\n Cargos: " + roles + "\n", true);
        embedBuilder.addBlankField(true);
        return embedBuilder.build();
    }

}


