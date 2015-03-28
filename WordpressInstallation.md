# Introduction #

With our new plugin and theme for Wordpress, you can now run Living Stories on your Wordpress-based blog, without dealing with the pain of building and deploying an App Engine or Tomcat application.  The plugin will add pages to your admin console that allow you to create our special content types and link them together.  The theme will modify your blog's look and feel and display the posts in the living story format, rather than a simple stream of posts.


# Required Plugins #

There are several plugins required to run Living Stories on your Wordpress blog.

  * Living Story Installer (http://wordpress.living-stories.googlecode.com/hg/living-story-installer.zip) - Optional, will automatically install dependencies for you.

  * Co-Authors Plus (http://wordpress.org/extend/plugins/co-authors-plus/)
  * TinyMCE Excerpt (http://wordpress.living-stories.googlecode.com/hg/tinymce-excerpt.zip)
  * Magic Fields (http://wordpress.living-stories.googlecode.com/hg/magic-fields.zip)
  * Living Story plugin (http://wordpress.living-stories.googlecode.com/hg/living-story-plugin_1_02.zip)
  * Living Story theme (http://wordpress.living-stories.googlecode.com/hg/living-story-theme_1_0.zip)

(Note: Magic Fields is accessible at http://wordpress.org/extend/plugins/magic-fields/, and TinyMCE Excerpt is available at http://wordpress.org/extend/plugins/tinymce-excerpt/.  However, the current versions of both have critical bugs that we've patched, so you should use the version in our source tree until the patches are pushed upstream.)


# Automated Installation <font color='red'><b>New!</b></font> #

  1. Download the living story installer listed above.
  1. Extract the plugin into your wp-content/plugins directory.
  1. Go to the 'Plugins' page in your Wordpress admin console, and active the new plugin.
  1. Create a page (`Pages > Add New`) called 'Post Loader' in your blog.  Set the visibility to 'private', and set the page template to the 'Post Loader' template that is included in the Living Story theme.  This is necessary for the dynamic loading of posts.  (TODO: This should really be automatic)
  1. That's it! You should be ready to create Living Stories.  Be sure to read the 'Creating Living Stories' section to understand how to use the interface.

Thanks to [Mohammad Jangda](http://digitalize.ca) for contributing the installer plugin!

# Manual Installation #

  1. Download the plugin and theme files listed above.
  1. Extract the plugin .zip files into to your wp-content/plugins directory. (Co-Authors Plus, TinyMCE Excerpt, Magic Fields, and the Living Stories Plugin)
  1. Extract the .zip file for the Living Story Theme to your wp-content/themes directory.
  1. Note: we suggest keeping the default folder names when extracting the plugin.  Some plugins may reference scripts in these directories.
  1. Go to the 'Plugins' page in your Wordpress admin console.
  1. Activate each plugin in turn (Magic Fields must be activated before the Living Stories Metadata Plugin)
  1. Once you activate the Living Stories Metadata Plugin, you should see a number of new sections in your admin console sidebar.  Each of these sections provides a special interface for creating different content.  If you don't see this, please read the troubleshooting steps below.
  1. Go to the `Appearance > Themes` page in your Wordpress admin console, and activate the Living Stories theme for your blog.
  1. Create a page (`Pages > Add New`) called 'Post Loader' in your blog.  Set the visibility to 'private', and set the page template to the 'Post Loader' template that is included in the Living Story theme.  This is necessary for the dynamic loading of posts.  (TODO: This should really be automatic)
  1. That's it! You should be ready to create Living Stories.  Be sure to read the 'Creating Living Stories' section to understand how to use the interface.


# Troubleshooting #

### I don't see the plugins/theme listed in my admin console ###
Try checking your wp-content/plugins or wp-content/themes directory to make sure the appropriate files are present.  Check that the permissions are set to world readable on all the files.  See http://codex.wordpress.org/Changing_File_Permissions for more information.

### The Living Stories Metadata Plugin gave a fatal error when I activated it ###
### OR I don't see any extra sections in my left-hand admin console sidebar ###
The Living Stories Plugin relies on the Magic Fields plugin, and expects it to be in a directory called 'magic-fields'.  If you have renamed this directory, you may see this error.  You can either change the directory name back, or modify line 8 of the plugin file (living\_stories.php) to point to the new Magic Fields path.

Also, remember to activate the Magic Fields plugin before activating the Living Stories plugin.

### My post isn't showing up in the Living Story ###
Make sure the post has the living story's category assigned to it.  Also, make sure you create your posts using the special categories on the left, rather than the generic 'add new' post link.  Generic wordpress posts without a content type assigned will not show up properly.

### All my posts stopped loading ###
Make sure to create your posts using the special categories on the left.  Generic posts may break the pages since the code doesn't currently support posts without a content type.  To check if you've inadvertently created a generic post, visit the 'Edit' link under the 'Posts' sidebar item.  Posts created using the special categories will not show up here, so any posts listed are ones with unassigned content types.

### My blog just looks like a normal blog with all my posts ###
We did not modify the theme's home page, since users will want to customize that themselves.  To see your individual living stories, you need to view the blog filtered by category.  Try checking out the 'Categories' links on the right of your blog.

### I have a question that's not answered here ###
Don't worry, we've got you covered.  Head over to our [help forum](http://www.google.com/support/forum/p/news/label?lid=5d770937692c7657&hl=en) and see if your question has been answered there.  If not, start a new post and we'll try to get back to you as soon as we can.


# Creating Living Stories #

There are a few things to remember when creating Living Stories:
  1. Each Living Story is a Wordpress Category.
  1. Each content item you want to appear in a Living Story should be assigned the corresponding category ID.
  1. Each theme in a Living Story is a subcategory (that is, a category with the Living Story category as its parent).
  1. Content items belonging to a theme should have both the Living Story category and the theme category assigned.
  1. You should create content items by using the special category panels on the left (Event, Narrative, Image, etc.)  Don't use the generic 'add new' post link; those will not show up in your stories (TODO: remove this link from the interface)

To begin creating a living story, visit the `Posts > Categories` page, and create a category that represents your living story.  The category name will be the living story name, and the category description will be the living story summary.

```
Tip: You can use special markup in your summary text:
<!--more-->  will add a 'Read more' link that breaks up your summary, hiding the text below until the user clicks.
<code>lsp:timeline</code>  will insert a timeline widget that displays all posts that are marked as high priority.
```

After you've created your category, you're ready to start creating some events.  Click the `Events > New` link to start writing a new Event.

Here, the post title is the headline text.  The excerpt will be shown before the 'Read more' link (behavior varies based on item priority), and the content will be shown as the event details, below the fold.  There are also other properties you can set here; notably, Date/Time (required), Priority (may be at the bottom of the page initially; you can drag this box higher up if you like) and Related Elements (these are the items that display as 'linked' in your living story event).

```
Tip: Priority determines how your post will display on the page.
A low priority event shows only the headline.  A medium priority event will show a portion of the excerpt, and a high priority event will show the entire excerpt.  High priority events will also show up automatically in the timeline widget, if you've added it in your living story summary.
```

Once you've created an event, you can view it in your living story by visiting the blog page filtered by your category.

You can also create other content types, such as images.  Images won't show up on your living story by default, but you can link them to event items to have them appear under the corresponding event.  Linking multiple images to an event causes them to display as a slideshow automatically when the user expands it.


# Viewing your data manually in the database #

The plugin uses the Magic Fields plugin to store the type and custom fields in each content item.  In your database, you will find a number of new tables to support the magic fields plugin.

Each content item type in a living story is stored as a separate write panel type in magic fields.  To determine what content type a post is, look for the post metadata in the wp\_postmeta table with key `_mf_write_panel_id`.  To determine what each write panel id maps to, see the `wp_mf_write_panels` table.

Common post fields like importance and location are stored as normal post metadata, in wp\_postmeta.  'Importance' (a.k.a. priority) is one example of this.

Fields specific to each post type are stored as magic fields data, in the `wp_mf_custom_field_*` tables.


# Porting to other themes #

The living stories theme is a modification of the default Kubrick Classic code.  Since the bulk of the UI is actually generated with Javascript in our GWT code, it should be very simple to move to a different theme, provided some rules are followed:

  1. The key .php files that manage the data written to the page are header-lsp.php, header-author.php, and content-util.php.  These three files write the script elements with the data to render to the page.  Additionally, post-loader.php is required for dynamic/async loading of posts.
  1. The header files also write the GWT loader script into the page.  If you're making modifications to these files, make sure to keep the `<script src="LivingStoryPage.nocache.js"/>` tag intact.
  1. We have modified category.php to get some values (namely, $category) prior to rendering the header.  This code needs to be preserved in any new theme.
  1. Remember to call header('lsp') and header('author') in the author.php and category.php files, respectively, rather than getting the standard header file.
  1. There are some div elements with ids that the GWT code expects to be on the page, which it will use to render the different elements.  The code will render the content thread to the 'contentList' div.  The filters will be rendered in 'filters', and the themes will be in 'themes'.  The living story summary will be rendered in the 'summary' div.  These divs must be present if you want the corresponding element rendered.
  1. The compiled GWT code is pretty much everything that's not a .css or .php file (other than util.js).  When you create your own theme, you need to copy the compiled GWT code into the theme directory.

# Contributing Patches #

Patches are welcome for this project!  Some key items that still need to be implemented are:
  1. Making the install process easier.  A wordpress expert could probably put together a plugin installer that eliminates the need for all those steps listed at the top of the page.
  1. Improving the admin interface.  Currently users need to remember to set the appropriate living story category on each post they write, or their post won't show up properly.  It would be awesome to make it possible to work in a single living story at a time.
  1. Making it easier to embed widgets, like the timeline. Adding some buttons to the TinyMCE editor would be a major improvement.
  1. Tracking read state.  User visits could be tracked with a cookie or integrated into the login system, so that unread posts could be highlighted appropriately.