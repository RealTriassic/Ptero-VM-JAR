# Ptero-VM in a JAR.
This project is a Java implementation of [Afnan's Ptero-VM](https://github.com/afnan007a/Ptero-vm) that was made for Pterodactyl, this project was created to support a even larger variety of hosting services than Ptero-VM could.

### How does this work
The jarfile downloads another file that can be seen [here](https://github.com/afnan007a/Ptero-vm/blob/main/installer.sh), afterwards it executes it, the script goes ahead and installs a PRoot enviroment in your server (also known as a docker container), this allows you to execute *most* root Linux commands on your server.

### Compiling Standalone
1. Download all of the files in the `Standalone Jarfile` folder.
2. Open a Terminal.
3. Run `mvn clean package` and you should get a jarfile in a folder called `target`.

### Compiling Bukkit Plugin
1. Download all of the files in the `Minecraft Plugin` folder.
2. Open a Terminal.
3. Run `mvn clean package` and you should get a jarfile in a folder called `target`.

### Issues
If you experience an issue whilst running or compiling Ptero-VM in a JAR, please open a new issue, if your issue is related to compilation, please make sure you are compiling correctly according to the guidelines above and that you have not tampered with the `.java` file.

### Contributing
Contributions are always welcome, feel free to open Pull Requests to contribute, or even consider starring the project, that also helps!

##### This project was made for educational purposes only and I, or the Ptero-VM creator shall not be held accountable for anything this project is used for.
