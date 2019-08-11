package github.benlewis9000.anvilanywhere.Resources;

/**
 * Represents the types of configs handled by the ConfigManager
 */
public enum ConfigType {

    SETTINGS("settings.yml"),
    PLAYERDATA("playerdata.yml");

    String name;

    ConfigType(String name){

        this.name = name;

    }

    /**
     * Get the name of the file the ConfigType represents
     * @return the filename as String
     */
    public String getName(){
        return name;
    }

}
