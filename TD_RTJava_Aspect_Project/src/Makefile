HOMEDIR = /opt/timesys/rtsj-ri

all: Application.class\
		ServerEcho.class\

Application.class: Application.java
	javac -target 1.3 -source 1.3 -g -classpath .:$(HOMEDIR)/lib/foundation.jar:$(HOMEDIR)/src/linux/classes:../lib/aspectjrt.jar tej/controller/Application.java

ServerEcho.class: ServerEcho.java
	javac -target 1.3 -source 1.3 -g -classpath .:$(HOMEDIR)/lib/foundation.jar:$(HOMEDIR)/src/linux/classes:../lib/aspectjrt.jar tej/controller/ServerEcho.java


run: 
	echo "This demonstration never stops.  Kill it when you are tired of it.";
	i386 -B -3 --uname -2.6 tjvm -Djava.class.path=.:../bin:../lib/aspectjrt.jar -Xbootclasspath=$(HOMEDIR)/lib/foundation.jar tej.controller.Application

run2: 
	export LD_ASSUME_KERNEL=2.4.1; tjvm -Djava.class.path=.:../bin:../lib/aspectjrt.jar -Xbootclasspath=$(HOMEDIR)/lib/foundation.jar tej.controller.ServerEcho

