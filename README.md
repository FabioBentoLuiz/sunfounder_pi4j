# sunfounder_pi4j
Sunfounder exercises in Java (pi4j)

#Installation
To install pi4j:
````
curl -s get.pi4j.com | sudo bash
```
#Compile
javac -classpath .:classes:/opt/pi4j/lib/'*' -d . [class name].java

#Execute
sudo java -classpath .:classes:/opt/pi4j/lib/'*' [class name]
