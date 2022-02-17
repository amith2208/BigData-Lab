# BigData-Lab

<h2>Commands to execute-</h2>
 <p>export HADOOP_HOME="hadoop_File_Path"</p>
 <p>gedit $HADOOP_HOME/etc/hadoop/hadoop-env.sh</p>
 <p>( add the java path in 54th line) i.e export JAVA_HOME="java_path"  To Check java path - readlink -f $(which java)</p>
 
 <p>export CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-3.2.2.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.2.2.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-3.2.2.jar:$HADOOP_HOME/lib/*"</p>
 
 <h3>Compiling Commands</h3>
 <p>-> javac -d . *.java</p>
 <p>-> create m.txt (Main-Class: package.driver)</p>
 <p>-> jar cfm t.jar m.txt package/*.class</p>
 <P>->$HADOOP_HOME/bin/hadoop jar t.jar input_file output</p>
