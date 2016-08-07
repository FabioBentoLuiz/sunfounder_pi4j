#Compile
javac -classpath .:classes:/opt/pi4j/lib/'*' -d . DualColorLED.java

#Execute
sudo java -classpath .:classes:/opt/pi4j/lib/'*' DualColorLED
