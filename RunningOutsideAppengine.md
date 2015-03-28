# Running Living Stories without App Engine #

Obviously, the easiest way to try out Living Stories is just to deploy the code on App Engine.  However, you may want to use different infrastructure for a variety of reasons.  If so, there are two main ways to do this:

1. Download the standard appengine version of the codebase and run it on [AppScale](http://code.google.com/p/appscale/).  This lets you run the code with few changes or additional work on your end.  However, the infrastructure you deploy on must be supported by AppScale (e.g. Amazon EC2)

2. Customize the code to work with your own servlet container and database servers.  See below for an example of how to get things working in Tomcat/MySQL.


## Demo Tomcat/MySQL deployment ##

We have created a simple demo of how one might customize the code to run in a different servlet/datastore environment--in this case, Tomcat/MySQL.  Since our data services are built on the Java Data Objects API (JDO), they are meant to be relatively portable and should work with a number of different JDO implementations.

These instructions have been tested in Ubuntu, and the commands shown should work in it and other Debian-based Linux distributions.  Installation instructions for other operating systems may differ slightly; refer to the documentation for more detailed information.

Also note that these instructions assume you have the appengine eclipse plugin installed, since that automatically gives you the DataNucleus support and builder configurations.  If you don't have it and don't want it, refer to the 'Troubleshooting' section for more information.

  1. Install [Tomcat](http://tomcat.apache.org/).  In Ubuntu, you can use
```
   apt-get install tomcat6
```
  1. Install the Tomcat Admin interface.  This step is optional, but makes deploying and managing your webapps a bit easier.
```
   apt-get install tomcat6-admin
```
  1. Install [mysql](http://www.mysql.com/).
```
   apt-get mysql-server
```
  1. Set up and start MySQL and create your living stories database.
```
   create database lsps;
```
  1. Download the tomcat demo code.  Note that this code differs from the appengine version in several significant ways. See [below](#Differences_between_App_Engine_and_Tomcat_code.md) for details.
```
   hg clone https://tomcat-demo.living-stories.googlecode.com/hg/ tomcat-demo
```
  1. Import the living story code into eclipse and build the project (Ensure that gxpc.sh and the datanucleus enhancer run).  Also do a GWT compile.
  1. Go into src/META-INF/jdoconfig.xml, and set your username/password/connectionUrl values for your database.
  1. Package the output directory into a `.war` file.
```
   cd war/
   jar -cvf lsps.war *
```
  1. Visit the Tomcat manager interface and upload the `.war` file (in the 'deploy' section).  This step assumes you've installed the admin interface.  If not, you'll want to copy your `.war` into the webapps directory of your tomcat installation.  Consult the documentation to determine where it is.

### Troubleshooting ###

  * No App Engine Eclipse plugin: The plugin is primarily used in these steps for the DataNucleus Enhancer builder.  If you don't have it, you may want to download the [DataNucleus Eclipse plugin](http://www.datanucleus.org/products/accessplatform_1_0/guides/eclipse/index.html) instead.  Alternatively, you may want to download the enhancer jar separately and [write your own Ant build script](http://www.datanucleus.org/products/accessplatform_1_0/guides/ant/enhancingwithant.html) to enhance your data entities.
  * 'Class not enhanced' exceptions: The DataNucleus enhancer either did not run or encountered an error.  Try going to 'Project > Clean' to clear out the generated files and get the enhancer to run again.  You may also want to ensure that your enhancer is set up properly--the App Engine Eclipse plugin should do this automatically; if you don't have it, refer to the previous troubleshooting item.
  * Java security exceptions: If you are running Tomcat with a Java security manager, you may need to modify its configuration to give your webapp the appropriate permissions.  For our Tomcat installation, this file was under YOUR\_TOMCAT\_BASE/conf/policy.d/04webapps.policy.  For testing purposes, you can give the webapp full permissions, but you may want to whittle this down a bit in production. (<font color='red'>TODO</font>: determine what the minimal set of permissions actually is)
```
   grant {
     permission java.security.AllPermission;
   };
```


## Differences between App Engine and Tomcat code ##

When customizing code for your own infrastructure, you may want to pay attention to the following roadblocks we encountered while porting the code off of App Engine.

  * java.util.Date fields need an extra 'is-second-class' extension on them.  Otherwise, DataNucleus attempts to wrap the values in their own custom date class, which is not serializable and thus breaks the GWT RPCs.
  * We use standard String variables to represent long text fields, rather than the custom App Engine 'Text' class.  To get these mapped correctly in your database, we use a JDO metadata file (`src/com/google/livingstories/server/dataservices/entities/package.jdo`) to specify their JDBC mappings.
  * Several services are currently set to stubs: the server cache, the user data service, and the user login service.  Since there won't be one standard implementation for these that works on different infrastructure, we have left these unimplemented.
  * We have added several additional jars for services originally provided by App Engine; namely: `mail.jar` (for SMTP support), `datanucleus-rdbms-1.1.5.jar` (for datanucleus support of relational databases), and `mysql-connector-java-5.1.12-bin.jar` (for the MySQL JDBC implementation).
  * Several additional configurations are required in our web.xml:
    * Create a login-config to tell the server to use Basic HTTP authentication
    * Create several new 'default' servlet-mappings to tell Tomcat to serve static files for URLs ending in standard file extensions, rather than trying to find a servlet that maps them.
  * Some datastore access methods were restructured.  It seems that in App Engine, it was OK to access query results after the query was closed, but this did not work anymore after switching infrastructure.
  * Got rid of App Engine encoded Key strings, and replaced them with simple auto-incremented primary key fields.  We originally needed the string encoded Key because App Engine requires it for owned relationships.  This is not necessary in our relational dbms.