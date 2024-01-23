package library.system;
public class Main
{
    public static void main(String[] args)
    {
        var commandsManager = new CommandsManager();
        commandsManager.ParseCommands();
    }
}
