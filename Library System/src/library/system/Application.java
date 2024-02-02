package library.system;


public class Application
{


    public static void main(String[] args)
    {
        DataBase.getInstance().getConnection();

        var commandsManager = new CommandsManager();
        commandsManager.ParseCommands();

    }


}
