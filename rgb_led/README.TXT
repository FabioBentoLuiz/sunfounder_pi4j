#Compile
javac -classpath .:classes:/opt/pi4j/lib/'*' -d . RgbLed.java

#Execute
sudo java -classpath .:classes:/opt/pi4j/lib/'*' RgbLed
