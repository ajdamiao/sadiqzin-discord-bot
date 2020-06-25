import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args)
    {
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT)
                .setAutoReconnect(true)
                .setToken("");
        JDA jda;

        jdaBuilder.setActivity(Activity.watching("Sadiq lindo"));

        PingPong pingPong = new PingPong();
        Reagindo reagindo = new Reagindo();
        Informacoes informacoes = new Informacoes();
        Filmes filme = new Filmes();

        jdaBuilder.addEventListeners(pingPong);
        jdaBuilder.addEventListeners(reagindo);
        jdaBuilder.addEventListeners(informacoes);
        jdaBuilder.addEventListeners(filme);


        try {
            jda = jdaBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
