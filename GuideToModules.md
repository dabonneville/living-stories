## Packages ##

The living stories tree is mapped below.  Click the package name for a description.

<a href='Hidden comment: 
Each of the links below MUST have a trailing space!
Otherwise the wiki puts the following item on the same line..
'></a>
<pre>
[#com.google.livingstories src/com/google/livingstories/]<br>
[#com.google.livingstories.client client/]<br>
[#com.google.livingstories.client.contentitemlist contentitemlist/]<br>
[#com.google.livingstories.client.contentmanager contentmanager/]<br>
[#com.google.livingstories.client.lsp lsp/]<br>
[#com.google.livingstories.client.lsp.event event/]<br>
[#com.google.livingstories.client.lsp.views views/]<br>
[#com.google.livingstories.client.lsp.views.contentitems contentitems/]<br>
[#com.google.livingstories.client.start start/]<br>
[#com.google.livingstories.client.ui ui/]<br>
[#com.google.livingstories.client.ui.richtexttoolbar richtexttoolbar/]<br>
[#com.google.livingstories.client.util util/]<br>
[#com.google.livingstories.client.util.dom dom/]<br>
[#com.google.livingstories.gxps gxps/]<br>
[#com.google.livingstories.server server/]<br>
[#com.google.livingstories.server.dataservices dataservices/]<br>
[#com.google.livingstories.server.dataservices.entities entities/]<br>
[#com.google.livingstories.server.dataservices.impl impl/]<br>
[#com.google.livingstories.server.rpcimpl rpcimpl/]<br>
[#com.google.livingstories.server.util util/]<br>
[#com.google.livingstories.servlet servlet/]<br>
[#war war/]<br>
[#war/WEB-INF WEB-INF/]<br>
[#war/images images/]<br>
</pre>


### com.google.livingstories ###

Top level directory.  The only files in here are our GWT module manifest files.  In general, you won't need to edit these, unless you add/change GWT classes and need to manage the compilation units.  Additionally, if you write a set of classes that rely on deferred binding for loading, you can put the deferred binding rules here.  Read more about managing
[GWT compilation units](http://code.google.com/webtoolkit/doc/1.6/FAQ_Client.html#Project_Architecture) and
[deferred binding](http://code.google.com/webtoolkit/doc/1.6/FAQ_Client.html#Deferred_Binding).


### com.google.livingstories.client ###

All code for client-side rendering goes in this directory or one of its children.  This is everything that GWT needs to render any of our pages (content manager, living story page, or start page).
The code directly in this package mainly represents our model classes and RPC interfaces, which are used by both the content manager and living story page.  There are also some enum definitions here.


### com.google.livingstories.client.contentitemlist ###

Code for displaying lists of content items lives here: We can create `ContentItemList` objects, which manage `ContentItemListElements`.  If the list is initialized with the right factory method, it will also wrap its elements in `ClickableContentItemListElements`, which call the `ContentItemClickHandler` that is passed in when clicked.
<font color='red'>TODO</font>: SummarySnippetWidget doesn't really belong in this package.


### com.google.livingstories.client.contentmanager ###

UI code for the content manager lives here.  Each 'tab' of the content manager is its own `*Manager.java` class, and they are all tied together by `ContentManager.java`, which serves as the entry point for the module.


### com.google.livingstories.client.lsp ###

UI code for the living story pages lives here.  We also put some non-UiBinder widgets in this directory, such as the code to render a content item popup, byline, or overview page filters.  The entry point for this module is `LivingStory.java`.  When the page is loaded, it will create the living story page chrome, then initialize the `HistoryManager`, which analyzes the url fragment to determine what page to load.  By default, this will be the overview page, which displays the summary and the living story event stream.


### com.google.livingstories.client.lsp.event ###

Custom events are in this package.  We use the Event Bus pattern to decouple some of our components by having them fire and receive events through a global event bus.


### com.google.livingstories.client.lsp.views ###

UiBinder classes for general living story page rendering.  Of note: `LivingStoryPage.java` is the main page chrome (logo, sign in link, header, and footer); `OverviewPage.java` is the default page that the users land on (summary, event stream, timeline, filters, etc); `PlayerPage.java` is the full-page view for people and organizations.  Other elements shown on the living story page are also here.

In addition, our Resources class and our main CSS stylesheet are also here.  See the [guide to CSS](GuideToCss.md) for more information.


### com.google.livingstories.client.lsp.views.contentitems ###

UiBinder classes for rendering individual content items.  This includes how to render preview, popup, and expanded versions of the content.

When rendering content, the user should call the appropriate factory class for each use case, rather than switching on content type and instantiating the classes directly.  This allows external code to convert between the model and view without knowing the details of what type of data it is or how it ought to be rendered.

There are a currently 3 view types for the content items:

1. Linked view - Renders the content for situations in which it is displayed as 'linked' to another content item.  Currently, this is used within the stream views for events and narratives, which are rendered as containers.  Use `LinkedViewFactory.java` to create these views.
2. Popup view - Renders the content for popup panes.  Use `PopupViewFactory.java` to create these views.
3. Stream view - Renders the content so it can be displayed in a content stream.  For events and narratives, this makes them expandable/collapsible and renders linked content in a panel on the right side.  For other content types, this generally just renders a preview which can be drilled into (lightbox for assets, full player page for players, etc).  Use `StreamViewFactory.java` to create these views.


### com.google.livingstories.client.start ###

Code for rendering the start page is here.  Currently this is just `StartPage.java`, which renders the entirety of the start page, and also serves as the entry point for this module.


### com.google.livingstories.client.ui ###

More general UI widgets.  These widgets can be used in a variety of situations, and might be shared between the living story page and content manager.  Things like disclosure panels with custom behavior (e.g. `ToggleDisclosurePanel`) live here.


### com.google.livingstories.client.ui.richtexttoolbar ###

Code for the rich text toolbar used by the content manager is here.  We have customized the toolbar with a few additional buttons (insertContentItem, insertSource, insertLightbox, etc.), and further customization is possible here.


### com.google.livingstories.client.util ###

Utility classes in use by the code.  Constants, commonly used data manipulation functions, date/time utilities, etc.  Of note: the `HistoryManager` is used to keep track of history state.  When the page is first loaded, this class inspects the url fragment to determine which page to load.


### com.google.livingstories.client.util.dom ###

Classes used to convert strings of HTML into DOM nodes that can be manipulated on both the server and the client.  On the client side, we use the native html parser directly (by calling GwtNodeAdapter.fromHtml(...)).  On the server, we use JTidy (JavaNodeAdapter.fromHtml(...)).  This is used primarily to snippetize event/narrative content on the client (content stream view) and the server (RSS feeds).


### com.google.livingstories.gxps ###

We use Google XML Pages (GXPs) as the foundation of our pages, rather than static HTML.  This lets us render parts of pages on the server side dynamically while still using a templating language close to HTML.  All of our GXPs can be found here.  Of note: `LivingStoryPage.gxp` renders the outer HTML for the living story page.  It writes a bunch of useful variables to the page so that the GWT code doesn't need to do a server roundtrip for some of the critical values.


### com.google.livingstories.server ###

Server side code resides in this package and its children.  This includes the entity definitions, RPC implementations, cache implementations, and servlet code.


### com.google.livingstories.server.dataservices ###

Interfaces for services that access the datastore.  If desired, advanced users may replace our implementation classes with custom ones of their liking if they do not plan to run against standard backends that support JDO.  It should be fairly straightforward to replace these implementations with one that accesses the datastore using JPA, for example.

For the most part, the datastore services are broken down by entity type.


### com.google.livingstories.server.dataservices.entities ###

This package contains the definitions of the JDO data entities that are used by the data interface implementations.


### com.google.livingstories.server.dataservices.impl ###

Implementations of the data interfaces.


### com.google.livingstories.server.rpcimpl ###

Implementations of the RPC interfaces used by GWT code to access data on the server.  We also use the appengine memcache in `Caches.java` to speed up our queries.  If moving off of appengine, you'll want to replace the appengine CacheManager with your own (e.g. JCS).


### com.google.livingstories.server.util ###

Utility classes for use on the server.


### com.google.livingstories.servlet ###

Servlet definitions.  Most of these are for general administration (e.g. `DataImportServet.java`, etc), though we also have servlets that render pages dynamically here.  Of note: `LspDispatcher.java` calls `LivingStoryHtml.gxp`, passing in a bunch of useful values used in GWT initialization.


### war ###

Many generated files/folders will show up here.


### war/WEB-INF ###

Server configuration files.  Of note: the `web.xml` and `appengine-web.xml` configuration files are here.  `web.xml` can be used to change which pages are admin-only, add new servlet mappings, etc.  `appengine-web.xml` is appengine specific, and lets you change your version number and set your app-id.


### war/images ###

Static image resources are here.