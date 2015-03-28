# Introduction #

Living Stories connects to a few external services that require a separate registration. Connecting to any and all of these features is optional; if you don't put in the necessary registration information, Living Stories will operate with that feature or those features silently disabled. The file that controls this configuration is <tt>war/WEB-INF/externalServiceKeys.properties</tt>

# External service configuration #

**Google FriendConnect**

The comments widget at the bottom of each living story is a Google FriendConnect widget.
[Developer signup here](http://www.google.com/friendconnect/admin/site/setup?hl=en)

Once you have signed up for FriendConnect, you will be given one or more site ids to pass to the FriendConnect API to identify yourself, and this id is specific to the connecting hostname. As such, you will probably want to register more than one site: for example, for your production environment, an internal-only sandbox, and localhost for local development tasks.

To specify all of these keys in externalServiceKeys.properties, use the <tt>friendConnectSiteId</tt> key. Specify it as a comma-separated list: the 1st, 3rd, etc. elements of the list should be a minimal suffix of the relevant hostnames, the 2nd, 4th, etc. elements of the list the site id to use with the preceding hostname. (You may separate pairs onto different lines, but don't forget to use a backslash before each new line to virtually splice the lines together.)


---


**Google Maps**

Authors may optionally set a location on any content item, which will then be displayed to users via a Google Map.  [Developer signup here](http://code.google.com/apis/maps/signup.html)

To specify your maps key in the file, use the <tt>mapsKey</tt> key. You may specify it as, e.g.,

```
mapsKey = key=12345678
```

or as

```
mapsKey = 12345678
```

Either will be understood.


---


**Google Analytics**

To receive information about how your users are interacting with living stories, including information on visit times, return visitors, and the specific controls on the page users click on, you can connect Living Stories to Google Analytics. [Developer signup here](http://www.google.com/analytics/sign_up.html)

To specify your analytics id in the file, use the <tt>analyticsAccountId</tt> key.

# Other customizations specified in externalServiceKeys.properties #

In addition to keys to external services, there are a handful of other useful settings in the file:

  * The logo file to use. Put an image of your organization's logo into war/images and specify the file name in the <tt>logoFileName</tt> key.
  * The publisher name to use in e-mail alerts sent to readers. Use the <tt>publisherName</tt> key.
  * The return address for e-mail alerts. Use the <tt>fromAddressName</tt> key for the name and the <tt>fromAddressEmail</tt> for the actual email address.