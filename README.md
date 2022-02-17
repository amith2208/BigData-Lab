# BigData-Lab

Commands to execute-
export HADOOP_HOME="hadoop_File_Path"
gedit $HADOOP_HOME/etc/hadoop/hadoop-env.sh
 ( add the java path in 54th line) i.e export JAVA_HOME="java_path"
 
 export CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-3.2.2.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.2.2.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-3.2.2.jar:$HADOOP_HOME/lib/*"
 
 Compiling Commands
 -> javac -d . *.java
 -> create m.txt (Main-Class: package.driver)
 -> jar cfm t.jar m.txt package/*.class
 ->$HADOOP_HOME/bin/hadoop jar t.jar input_file output
