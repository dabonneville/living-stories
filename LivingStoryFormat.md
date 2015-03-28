


# What are Living Stories? #

Living Stories are a new format for presenting and consuming online news. The basic idea of a living story is to combine all of the news coverage on a running story on a single page. Every day, instead of writing a new article on the story that sits at a new URL and contains some new developments and some old background, a living story resides at a permanent URL, that is updated regularly with new developments. This makes it easier for readers to get the latest updates on the stories that interest them, as well as to review deeper background materials that are relevant for a story's context.

A reader can read full articles and browse multimedia without ever leaving the Living Story page. By expanding and minimizing various levels of details on various developments in the story according to the context, a lot of information is presented to the user on one page in an organized manner. Whether it's just a short update, or a deep analysis, or a feature story, a video, or an important quotes, everything related to the story is on the Living Story page.

Living Stories also automatically track the reader's interaction with the story, so that the new material on the page since their last visit can be highlighted. This enables users to quickly see what's new since they last read the story.

To see Living Stories in action, go to http://livingstories.googlelabs.com and click on one of the listed stories. These stories were created for a Labs experiment that ran from Dec 2009 - Feb 2010 by a partnership between Google, the New York Times, and the Washington Post. This open source package lets you create similar living stories on your own website.



# Core Principles #

Following are the core elements of the Living Story format:

**1. Unified Coverage**

Coverage related to a story is connected and available on a single web page, which is the Living Story page. This web page includes news articles and associated content such as images, videos, graphics, background, feature articles, etc.

The definition of what constitutes a living story is subjective. But in general, the lifespan of a living story is longer than that of individual news articles and shorter than that of topic pages. For example, "Sonia Sotomayor" is a topic page, whereas "Sonia Sotomayor's nomination and confirmation" is a living story. "AIG" and "Credit Crisis" are topic pages, but "AIG's bonus controversy" is a living story.

**2. Story Summary**

The Living Story has a running summary of the developments that have unfolded in the story so far. The purpose of the summary is to serve readers who are new to the story or have been loosely following it. The summary should give them a high-level view of the important developments that have occurred so far, as well as sufficient context to understand the detailed coverage.

**3. Story Developments**

A story's developments often provoke new coverage. In the Living Story format, the content of a story is organized by its developments. Each development has a short description or an "update." All coverage of that development, including news articles, pictures, quotes, videos, analysis, etc., is connected to the update. Taken together, the updates can be read as a time line to understand the sequence of things that happened in the story. If important events are being covered live, updates can be posted in real-time and details can be added later.

**4. Various levels of detail**

Each story development offers various views that contain different levels of detail to cater to readers with different levels of interest. The title of the development or the "update" gives the user a one- or two-sentence high-level description. Every event also has a "summary" which contains the most important factual information about the development. Reading this should give someone an overview of what happened. The summary can contain one to three paragraphs of text and/or multimedia and graphics that are important to explain the development. Lastly, the "full view" contains all the details for a development including additional information, additional multimedia, people associated with the event, interesting quotes, feature articles, analysis and so on.

**5. Prioritization of story developments**

Every story development and every piece of content in a living story is prioritized by how important it is to the story. This gives readers, particularly those who are new to the story or have not been following it closely, a choice of exploring only the most important developments, for example. It also lets you convey how much attention you want the reader to give to different aspects of a story.

**6. Remembering what the user has read**

In order to provide a more personalized experience to each reader, the Living Story keeps track of what the user has read i.e. the "read state". The page highlights the changes and new updates since the user's last visit so that he or she can quickly see what they need to read.

This open source package (and the Google Labs experiment) represents one possible implementation of these principles. Any news organization, however, can use the principles as a guide to implement their own version of living stories on their site, that suits their content and readers better.



# Best Practices #

Besides the core principles above, we found a few other characteristics for Living Stories, which while not essential, can be regarded as general best practices:

**1. Repetition should be kept to a minimum**

Traditionally news articles provide a high-level summary of the developments in the story so far with every article. Since the living story has a summary section specifically dedicated for this, a summary doesn't need to accompany every update or narrative. As another example, background information that is necessary for getting context of the story is created just once and linked wherever appropriate, but need not be re-written with every article. As another example, if a person is playing an important role in the story and is mentioned often in the different articles about the story, information about their profile and specific role can be created just once and linked wherever necessary, and doesn't need to follow every mention of their name.

This practice ensures that readers who are following the story closely don't have to spend time going through background and other information that they already know. But it is still available to readers who want to see it.

**2. Full attribution**

For every piece of content, including photographs, videos, graphics, etc. readers should be able to see the names and biographies of the reporter, photographer, graphic designer, etc. who created it. And they should be able to easily see the full body of work from that contributor.

**3. Source material**

Sources of information, data and facts mentioned in the content should be exposed wherever possible. For example, copies of government documents, audio transcript of interview that the article is using quotes from, links to webpages from which data was compiled for a graphic, etc. It should be easy for contributors to associate this information with content. It should also be presented such that readers who are interested can find it easily, but readers who are not can skip it just as easily.

**4. Search and filter**

All the content on a living story page should be searchable. There should also be various options for users to filter the content in different ways, such as by time, by importance, by type, by contributor, etc.

**5. User discussion**

Along with all the coverage on a story being available at a single URL, all the discussion around the story in the form of user comments, expert commentary and trackbacks should also be available on the same page, preferably as contextualized as possible with the update the discussion is about.

**6. User contributions**

If appropriate, users should be able to contribute to the improvement of the content on the story page. For example, they should be able to request a typo correction, or request source material for a cited fact, or request a photograph be captioned, or ask for clarification of a piece of text. These requests would be treated as suggestions for the editors of the living story and would be non-binding.
Users should also be able to send in their eyewitness photos, videos, etc. of an event, which can be edited and approved by the publisher prior to going live on the page. Users should be able to see all of their contributions including comments in a single place.

**7. Story tracking**

Users should be able to keep track of the stories they are following or interested in via various methods such as email alerts, RSS feeds, etc.

The open-source package contains implementations of some, but not all, of these principles.