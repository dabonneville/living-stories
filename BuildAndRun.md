# Steps to build and run the living stories application #

Living Stories is an [AppEngine application](http://code.google.com/appengine/docs/whatisgoogleappengine.html). It has been written using the [AppEngine Java SDK](http://code.google.com/appengine/docs/java/overview.html). The frontend is built with [Google Web Toolkit (GWT)](http://code.google.com/webtoolkit/). The Java version used is 1.6.

The living stories source code lives in a Mercurial Repository. Read more about Mercurial [here](http://code.google.com/p/support/wiki/GettingStarted#Working_with_your_Source_Repository).

Below are instructions for building the code and running the server from [Eclipse](http://www.eclipse.org/downloads/). You can follow similar steps for other IDEs. These instructions are for running the code with AppEngine and storing the data in the AppEngine datastore. You can also run the code outside of App Engine, see [this wiki page](RunningOutsideAppengine.md) for more information.

Windows users may also want to see some [Windows-specific tips](#Tips_for_Windows_Users.md) if they are having trouble.

  1. Install the Google Plugin for Eclipse from http://code.google.com/appengine/docs/java/tools/eclipse.html. In step 3 of the process outlined there, make sure to also check the 'Google Web Toolkit SDK' box.
  1. Get a local copy of the living stories repository by running the following command:
```
    hg clone https://living-stories.googlecode.com/hg/ living-stories
```
  1. Import the project into Eclipse
    1. The checked in code contains a .project file for Eclipse at the root.
    1. In Eclipse, choose 'Import' from the 'File' menu.
    1. Choose 'General' and 'Existing projects into workspace' in the wizard window.
    1. In the 'Select root directory' window, provide the path to the root of the downloaded source.
    1. Click 'Finish'
    1. The eclipse project is called "living-stories".
  1. Verify that the SDKs are set up correctly
    1. Right click on "living-stories" in the package explorer view. Select 'Google' and then 'Web Toolkit Settings'. Make sure the selected GWT SDK version is 2.0.0.
    1. Right click on "living-stories" in the package explorer view again. Select 'Google' and then 'App Engine Settings'. Make sure the selected AppEngine SDK version is 1.3.0.
  1. Open the `/war/WEB-INF/appengine-web.xml` file and provide your appengine app id where it says "insert-your-app-id-here". You can obtain an id from the appengine admin console at https://appengine.google.com/. You can skip this step for local experimentation until you deploy the app on AppEngine.
  1. The `/war/WEB-INF/externalServiceKeys.properties` file also needs to be provided some values for your running environment. See [instructions](http://code.google.com/p/living-stories/wiki/ExternalServices) for that here. You will want to provide all those values before deploying your app externally. But for local experimentation, you can proceed without providing all the values.
  1. Select the 'Project' menu in Eclipse and then 'Clean' the project.
  1. Create a debug configuration for the project and run it locally
    1. Go to Run > Debug Configurations..., and double-click the 'Web Application' entry in the list on the left.
    1. This should create a new debug configuration in the pane on the right.  Feel free to change the name from 'New\_configuration' to anything you like.
    1. In the 'Main' tab, click 'Browse' and select the living-stories project.  Also ensure that the 'Run built-in server' option is checked.
    1. In the 'Arguments' tab, enter the following in the 'Program Arguments' box:
```
      -startupUrl ContentManager.html
```
    1. Also note the error in the top of the Debug Configurations window, about adding a VM argument.  Copy the displayed flag (should start with `-javaagent`) and paste it into the VM arguments box.
    1. Click 'Apply' to save this configuration, then click 'Debug' to run it.
  1. The GWT Development mode pane will open up in Eclipse and give you the instructions for accessing the application. It will tell you the gwt.codesvr address which has to be provided as a param to every URL you visit on the browser for your local instance. Let's say that URL that GWT told you was: http://localhost:8888/ContentManager.html?gwt.codesvr=127.0.0.1:9997 (your URL may be different). Copy paste this URL into your browser to access the content manager where you can enter data.
  1. You can type any fake email address into the login screen that pops up. Check the 'admin' box. The content manager has admin-only access, so that it is not visible to outside users. You can learn more about how security and authentication work in AppEngine here: http://code.google.com/appengine/docs/java/config/webxml.html#Security_and_Authentication
  1. Note that logging in may cause your gwt.codesvr parameter to get lost, which is bad.  If that happened, try navigating to the original URL again (your login should be preserved).
  1. Create and view your first living story
    1. When you reach the content manager screen, click on the 'Manage Living Stories' tab and then on the 'Create button'. Enter "test" in the dialog box that pops up - this will be the URL for your story. Enter some data for your test living story and then click the 'publish' button.
    1. Then click on 'Manage Content' tab. Your newly selected story should be selected. Click on the 'Create new' button and enter some data for your first test living story content. Then click the 'publish' button. Detailed instructions for how the content manager works are [here](http://www.google.com/url?q=http://code.google.com/p/living-stories/wiki/ContentManager).
    1. Now visit this URL in your browser: http://localhost:8888/?gwt.codesvr=127.0.0.1:9997 This homepage shows a listing of all the living stories created in your system. Your test living story should show up there.
    1. Click on the story name from the homepage. You will be taken to http://localhost:8888/lsps/YOUR_LSP_NAME#OVERVIEW:false,false,false,n,n,n:null;.  Again, the gwt.codesvr parameter may get lost in this transition.  You will need to insert the parameter manually: http://localhost:8888/lsps/YOUR_LSP_NAME?gwt.codesvr=127.0.0.1:9997#OVERVIEW:false,false,false,n,n,n:null; for the page to work. You should see the story summary at the top and the test content you entered below.

You can now enter more content in the content manager and then view it in the user-facing living story pages. You can also [customize the look and feel of the page](http://www.google.com/url?q=http://code.google.com/p/living-stories/wiki/UserInterfaceCustomization) by editing the code.


### Tips for Windows Users ###

Since the project configuration is set up for Linux systems by default, there are a few more changes you may need to make before your project will build.

1. Right click on the project in eclipse and click on 'Properties'.  Go to 'Builders', select the 'GXPC' entry on the right, and click 'Edit'.  Change the 'Location' field to point to gxpc.cmd rather than gxpc.sh.

2. If you are getting an error (NullPointerException) from DataNucleus when building the project, try this: right click on the project in eclipse and click on 'Properties'.  Go to Google > App Engine > ORM in the treeview on the left.  In the right pane, remove all the entries there, and add src/com/google/livingstories/server/dataservices/entities as the enhancement path.


### Troubleshooting ###

Some users have mentioned getting 'Unbound classpath container: JRE System Library' errors.  This may be related to our use of an alternate JDK; try right clicking on 'JRE System Library' in your project, going to 'Properties', and selecting 'Workspace default JRE' to use the default Java Runtime installed on your machine.

If you get an error saying that the source folder `genfiles` does not exist, try creating it (or do an `hg pull`; we recently added a hidden placeholder file in that directory to force its creation).  You may then need to run `gxpc.sh` (or `gxpc.cmd` for Windows) manually to get the .gxp template files to compile.


### Other Tips ###

For deploying the application to AppEngine, read the instructions here: http://code.google.com/appengine/docs/java/tools/uploadinganapp.html

For a demo of how to get the code running off of App Engine, [click here](RunningOutsideAppengine.md)