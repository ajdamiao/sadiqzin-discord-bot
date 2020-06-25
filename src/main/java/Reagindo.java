import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reagindo extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        if(e.getMessage().getContentRaw().contains("pensar") || e.getMessage().getContentRaw().contains("pensando"))
        e.getMessage().addReaction("\uD83E\uDD14").queue();
        if(e.getMessage().getContentRaw().contains("gay") || e.getMessage().getContentRaw().contains("pensando"))
        {
            e.getMessage().addReaction("\uD83C\uDFF3️\u200D\uD83C\uDF08").queue();
        }
    }
}
