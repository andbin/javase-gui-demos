# JavaSE GUI Demos

This project contains a set of simple GUI (Swing) demos for the JavaSE Platform. Each demo is entirely standalone and separated from the other demos. There is also a main application that acts as a “launcher” for all the demos.

## License

This project is released under the **MIT No Attribution License**, a very *permissive* free software license.

See the full text of the license: **[LICENSE.txt](LICENSE.txt)**

## How to build and run

This project requires a **Java 8** (or higher) runtime. To build the project, you also need [**Apache Maven**](https://maven.apache.org).

You can build and run the application in different ways (depending on your environment and/or IDE):

**Option 1)** From the command line (in the project’s main directory):

* run `mvn compile exec:java`

**Option 2)** From the command line (in the project’s main directory):

* run `mvn package`
* go into the `target` directory
* run `java -jar javase-gui-demos.jar`

**Option 3)** From your preferred IDE (e.g., Eclipse or IntelliJ IDEA):

* import this project as a “Maven project” and ensure it is compiled
* launch the `guidemos.DemosLauncherApplication` class
