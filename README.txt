TP de Compléments en Programmation Orientée Objet no 1 : Gradle, objets, classes et encapsulation

Date :  23/09/2019

Version de JAVA :  OpenJDK 12  (http://jdk.java.net/archive/)
Version de Gradle :  Gradle 5.6.2
Kotlin: 1.3.41
Groovy: 2.5.4
Ant: Apache Ant(TM) version 1.9.14 compiled on March 12 2019

IDEs Utilisés dans ce projet :  IntelliJ IDEA Community Edition 2019,    Visual Studio Code

Utilisation sur Terminal de  IDE  :  IntelliJ IDEA Community Edition 2019



EXEMPLES SUR WINDOWS 10 ( ATTENTION le File Separator sur Windows c'est anti-slash '\' alors que sur LINUX c'est slash '/' )


Tous les chemins des répertoires des fichiers sont relatifs au répertoire du projet de IntelliJ IDEA Community Edition 2019


tpGradleIntelliJ> gradle build

BUILD SUCCESSFUL in 884ms
-----------------------------------------------

tpGradleIntelliJ> gradle run --stacktrace --args="-help "


> Task :run
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\
usage: TestCommonsCLI

 -c <arg>   create zip file
            Example :
            gradle run --stacktrace --args="-c monfichier3.zip   tp1Gradle.pdf README.txt "

            gradle run --stacktrace --args="-c monfichier2.zip zipTest\source\file1.txt zipTest\source\file2.pdf zipTest\source\file3.png "

 -help      print this message :  gradle run --stacktrace --args="-help "


 -x <arg>   extract zip file
            Example :
            gradle run --stacktrace --args="-x monfichier3.zip
            zipTest\destination"

BUILD SUCCESSFUL in 1s

-----------------------------------------------------------------------------------------


tpGradleIntelliJ>  gradle run --stacktrace --args="-c monfichier3.zip   tp1Gradle.pdf README.txt "

> Task :run
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\
 Option Argument Value  zipFileName = monfichier3.zip
CREATE--files-- tp1Gradle.pdf
CREATE--files-- README.txt
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\

BUILD SUCCESSFUL in 1s


--------------------------------------------------------------


tpGradleIntelliJ>gradle run --stacktrace --args="-c monfichier2.zip zipTest\source\file1.txt zipTest\source\file2.pdf zipTest\source\file3.png "

> Task :run
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\
 Option Argument Value  zipFileName = monfichier2.zip
CREATE--files-- zipTest\source\file1.txt
CREATE--files-- zipTest\source\file2.pdf
CREATE--files-- zipTest\source\file3.png
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\

BUILD SUCCESSFUL in 1s


-----------------------------------------------------------------------


tpGradleIntelliJ>  gradle run --stacktrace --args="-x monfichier3.zip     zipTest\destination"



> Task :run
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\
 Option Argument Value  zipFileName = monfichier3.zip
Current Directory Path (Project Directory) : C:\Users\karl2\IdeaProjects\tpGradleIntelliJ\
eXtract dirDestination: zipTest\destination

BUILD SUCCESSFUL in 1s


-------------------------------------------------------------------------------------------------

Generer un JAR dans Install

  // Voir dans le fichier build.gradle
  // The Distribution Plugin https://docs.gradle.org/current/userguide/distribution_plugin.html
  //   id 'distribution'



tpGradleIntelliJ>   gradle installDist

BUILD SUCCESSFUL in 1s

Regarder dans le répertoire build/install/projetTestGardle/bin  et /lib  avec les fichiers JAR Tout est prêt pour déployer
le logiciel ( application) en "prod" (production).

----------------------------------------------------------------------------------

Suppression du répertoire BUILD/

tpGradleIntelliJ>  gradle clean

BUILD SUCCESSFUL in 862ms
