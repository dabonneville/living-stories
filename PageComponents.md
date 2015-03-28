A living story page has the following suggested components that implement the [core principles and best practices](LivingStoryFormat.md), and are included in this open-source package:



http://wiki.living-stories.googlecode.com/hg/components.JPG

# 1. Summary #

A summary at the top of the page provides an overview of the entire story. For readers who haven't been following the story from the very beginning, the summary should orient them to the background and important developments. The summary should be edited if there is a significant new development in the story. The summary can contain links to the rest of the content on the page. A summary is generally 3-6 paragraphs and part of it can be collapsed, such that it is only made visible when the reader clicks on 'Read more'.

Changes in the summary are highlighted for returning visitors. If a reader is coming back to the story, and there have been no substantial changes in the summary, it is collapsed. If there have been substantial changes, they are highlighted in yellow. If there have been substantial changes in the part of the summary that is collapsed by default, then it is expanded automatically. This draws the readers' attention to the changes since their last visit, and lets them skip the summary if they have already read it.

The summary can also optionally contain a horizontal timeline. This timeline is automatically generated from the most important events in the story. Users can scroll left and right on the timeline to see more events. Clicking on the items in the timeline scrolls the page and takes the user to the details for that update.

# 2. The update stream #

The center of the lower half of the page contains a series of updates on the story in reverse-chronological order. Each update can be individually expanded and collapsed by either clicking on the headline or on the 'Read more' link. An update can have 3 levels of details:
  * Headline (required): maximum of 1 or 2 sentences that describe a new development in the story
  * Summary: a 1-3 paragraph summarization of the important facts for a new development. After reading this, the user should have a fairly good idea of what happened. The summary can also contain important photos, videos, graphics, etc. that are helpful in quickly visualizing the development. The summary is expanded or collapsed by default depending on various factors explained below.
  * Details: The rest of the detailed coverage for a development goes into the details. The details can contain various content types such as photos, videos, graphics, resources (i.e. external links), quotes, maps, reactions, and a default catch-all category if the content doesn't fit into any of the other types. The details are usually collapsed by default, unless the user has followed an update-specific link to the page instead of the home link.

Prioritization of all content types is a core principle of the Living Story format. The importance values for the various pieces of content are used in several ways in the update stream. The low-importance updates are shown in smaller font. For high-importance updates, the full summary is always expanded by default. For medium-importance updates, the summary is expanded by default is the update is new and the user hasn't seen it before. It is collapsed to a medium-sized snippet if the user has seen the update before. The summary of low-importance updates is always collapsed by default.

Some content types are floated to the right column of an update block. These include assets such as photos, videos, graphics, resources and documents; people and organizations; quotes. The rest of the content types such as background, reaction, narratives, etc. are shown in the main column of the block. If there are narratives linked to an update in the stream, their headlines are shown in the expanded section. The ordering of the various content types within an update block is determined by their importance and their "read state".

The update stream can have content of 2 types: "events" and "narratives". The content types are explained in more detail in the section below. The headline of narratives is followed by an indicator of the type of narrative such as "Feature", "Op-Ed", etc. The 2 content types behave similarly in the update stream in most ways. All the other content types appear in the default stream if they are linked from an 'event' or 'narrative' update.

Each individual update block can be linked to uniquely. The link can be obtained by expanding an update and clicking on the "Share" button on the bottom right of the block. When a user clicks on an update link, they come to the living story page but are scrolled down to the corresponding update which is expanded.

# 3. Filters #

The left column of the page has a series of controls for filtering the content in different ways. At the top, below the "All coverage" option, is a list of Themes. Themes can be created for any living story and represent different areas or threads of coverage within the larger story. When each piece of content is created, it can be associated with 1 or more themes. When the user clicks on one of the theme names in the left column, their stream is filtered to just show updates from that theme.

Below the themes are content type filters. By clicking on these, the user can explore a particular type of content further such as just photos, or just all the opinion articles, or all the resources, or all the people involved with the story.

After that, the user has the option to view just the most important updates. Following that, the user has the option to change the ordering of the updates.

Lastly, the user can set any of these filtered views as their default view if they are signed in. For example, if the user has chosen the "News" content type and the "Most important only" filters, and they click on 'Set as default view', if they visit the default home link for any story, this filter will be auto-selected and they will be shown only the most important "News"/"Event" updates in the stream by default.

# 4. Timeline #

The timeline on the right provides a quick snapshot of the story's most important and recent developments. It is automatically generated from the last 5 high-importance "event" updates. Clicking on the headlines in the timeline scrolls the user to that particular update in the stream and expands it. The timeline on the right also stays with the user as they scroll down so that they can always have context of the recent developments in the story and use it as a navigation aid.

# 5. Follow a story #

There are currently 2 ways for users to follow the story without coming back to the page itself. They can either subscribe to email alerts or to an RSS feed for the story. These links are available on the top right of the page.

If you develop other interesting components for your living story pages, we would love to hear about it on our [help and discussion forum](http://www.google.com/support/forum/p/news/label?lid=5d770937692c7657&hl=en)!