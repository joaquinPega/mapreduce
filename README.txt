In this project you will find template classes with TODO comments where you are
required to complete functionality. Check the instructions on each of them,
complete them and run the tests. Once the tests are passing,
you have finished the practice for Hadoop Map Reduce.

In order to install the required testing dependencies,
- ensure Maven is installed
- go to the lib folder
- execute:
mvn install:install-file -Dfile=./map-reduce-1.0.0-SNAPSHOT-tests.jar -DgroupId=big-data \
               -DartifactId=map-reduce -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar

Tests are run the classes you find inside the com.bigdata package and sub-packages
You are only allowed to complete the existing code template.

Once you completed the classes and the tests ensure they are OK, you may gain
deeper understanding of Hadoop by packaging them into a jar and executing against huge files.
This way you will deal with a real Hadoop execution and not only map-reduce coding. This are
out of scope for the training. For Hadoop installation instructions check http://hadoop.apache.org/

http://www.cloudera.com/content/support/en/downloads.html
