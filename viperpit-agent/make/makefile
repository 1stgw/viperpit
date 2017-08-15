# Define a variable for classpath
CLASS_PATH = ../bin

# Define a virtual path for .class in the bin directory
vpath %.class $(CLASS_PATH)

all : bms433.dll

# $@ matches the target, $< matches the first dependancy
bms433.dll : bms433.o
	g++ -shared -o $@ $<

# $@ matches the target, $< matches the first dependancy
bms433.o : BMS433.cpp BMS433.hpp
	gcc -m64 -I"C:\Program Files\Java\jdk1.8.0_111\include" -I"F:\Games\Falcon BMS 4.33\Tools\SharedMem" -O0 -g3 -Wall -c -fmessage-length=0

# $* matches the target filename without the extension
#BMS433.h : FlightData.class
#	javah -classpath $(CLASS_PATH) $*
	
clean :
	rm bms433.h bms433.o bms433.dll