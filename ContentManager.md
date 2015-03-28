The open source code comes with a "Content Management" interface that you can use to enter your content in the Living Story format. You can access it at:
http://your-hostname/ContentManager.html.

This page is accessible only to admin users of the application. (In AppEngine, this means you have to be invited to be a developer of the application.)



# Creating and editing Living Story entities #

  1. Click on the "Manage Living Stories" tab.
  1. Click on the "Create" button.
  1. Enter the unique URL identifier you want to use for your story. Each story in your system will need to have a unique identifier. You can make it something descriptive like "HealthCare" or "health-care". The word/phrase you enter here will determine how your story will be served. For example, if you use "HealthCare" as the URL for your story, the story will be served to users at: http://your-hostname/lsps/HealthCare
  1. Click 'Save'.
  1. Enter a Title for the story in the place of 'New Story'. This title will be displayed at the top of the living story page. Eg. "The Struggle Over Health Care Reform". The title of the story can be modified in the future if it significantly changes, but in general, the title should be broad and descriptive enough that it doesn't have to change very frequently.
  1. Enter a summary for the story in the big editor box. The summary should give readers an overview of the significant developments and importance of the story, and orient them to the rest of the material on the page. It is displayed at the top of the living story page. You can format the summary using the buttons at the top of the editor box (see the [section below](#Formatting_the_summary.md) for some special formatting features). You can hover over the buttons to see what they do. You can do more advanced HTML formatting by clicking on the 'HTML' tab and directly editing the HTML. You can change the summary as often as you like. If there have been changes to the summary since a user's last visit to the page, the changes are automatically highlighted.
  1. Click 'Update preview' to see a preview of what the summary will look like on the page.
  1. At this point, you can either save the story as 'draft' or publish it. Saving the story as 'draft' means that it will not yet appear on the start page that contains a listing of all the stories. Every time you change the summary, remember to hit the 'publish' button and wait for the success message to appear in green to make sure your changes have been saved.

## Formatting the summary ##

The summary has a few special formatting features:

### Collapsing part of the summary ###

If the summary hasn't changed since the user's last visit to a story page, part of the summary can be automatically collapsed such that it is only visible when the user clicks on 'Read more' and not visible by default. In order to specify the point after which the summary should be hidden:

1. Click on the "HTML" tab in the summary editor box

2. Insert the following code after the end of a paragraph:
```
<!--lsp:break-->
```
> Everything after this code will be collapsed by default unless you make changes to it.

3. Click back on the "Rich Text" tab.

The break should generally be inserted after the first or second paragraph of the summary.

### Inserting a timeline ###

You can insert a timeline into the summary which gets automatically populated from the content items you create for the story. In order to do this:

1. Click on the "HTML" tab in the summary editor box

2. Insert the following code at the point you want the timeline to display:
```
<code width="700" height="125">lsp:timeline</code>
```
> You can adjust the width and height of the timeline above.

3. Click back on the "Rich Text" tab.

If you insert the timeline code before the break code above, the timeline will always be displayed. If you insert it below the break code, it will only be visible when the reader clicks on 'Read more' in the summary.

The timeline is automatically populated from the content items of type "Event" that are marked as high-importance.

### Linking to specific content items ###

See [below](#Special_links_within_the_content.md) for the several ways to create internal links from within the content of the living story summary. In order to create links to content items from the summary, the content items first have to be created through the 'Manage Content' tab. (See [below](#Creating_and_editing_Content_Item_entities.md) for the process of creating a content item). Once a content item is created, you can come back to the 'Manage Living Stories' tab and link it from the summary.


# Creating and editing Theme entities #

  1. Click on the 'Manage Themes' tab
  1. Select the story to which you want to add a theme from the dropdown at the top
  1. If you are creating a new theme, enter its name in the text box. Eg. "Senate negotiations". and then click 'Save'.
  1. If you are want to edit or delete an existing theme, click on the 'Rename an existing theme' radio button. Select the theme you want to edit or delete from the list. To edit it, change the text in the box and click 'Save'. To delete it, click the 'Delete' button.
  1. Wait for the success confirmation message to make sure the changes were saved.


# Creating and editing Content Item entities #

1. Click on the 'Manage Content' tab

2. Select the story you want to add to from the dropdown on the top left.

3. Click on the 'New Content Item' button if you are creating a new item or select an existing item from the list below if you are editing. You can use the filter above the list to narrow down to specific item types to find the item you want to edit.

4. Select the type of content you want to create from the first dropdown. By default, the type is 'Event'. You can see an explanation of the different content types and their special properties [here](http://code.google.com/p/living-stories/wiki/DataStructure#Content_Types).

5. Fill in the special fields for the content type you have selected.

6. The 'Content' field is common for all types (except images). Here, you have to enter the HTML for rendering the details/full view of your content item. You can format the content using the buttons at the top of the editor box. You can hover over the buttons to see what they do. You can do more advanced HTML formatting by clicking on the 'HTML' tab and directly editing the HTML. See [below](#Special_links_within_the_content.md) for several ways to create links to other content from within this content.

7. Select an importance/priority for your content item. The default is 'Medium'. Items of different priority are displayed in different ways on the page. Only important event items appear in the automatically generated timelines. See an explanation [here](http://code.google.com/p/living-stories/wiki/PageComponents#2._The_update_stream).

8. Add the name of the author/contributor of this item. Start by typing the person's name. If it is already present in the system, it will appear in the list of suggestions. Select the name from the suggestion list and either hit the 'Enter' key or click on the 'Create or Add' button. If the name of the contributor is not present in the system, type it in the box and then click on the 'Create or Add' button. A window will pop up where you can enter more detailed information about the author such as their biography, a photo, etc. (Ignore the Aliases field.) Click on 'Save' after entering the detailed information.

Contributors can be added for any content type such as photographers for an image, etc. For some content types, there are no contributors such as 'Editorials'. Contributors are required for Events and optional for all other types.

9. If you want to associate the content item with any of the themes you have created for this story, click on the 'Themes' zippy to expand it. Then select the themes. You can associate an item with multiple themes by holding down the 'Ctrl' key.

10. If you want to provide source information for the content item you are creating, click on the 'Source Information' zippy to expand it. You can use these fields for providing details about the source of the information in the content. You can enter source information in either one or both of the following fields:
  * point to another content item as the source of information in this content item. For example, you may have created an Asset item containing an audio transcript of an interview with someone. And now you are creating a "Quote" item from one of the quotes from that interview. In this case, you can click on the 'Select item' button while creating the Quote and then choose the audio Asset item as the source.
  * write a text description of the information source. Eg. "Information obtained from Jane Doe, advisor to John Doe", or "Information obtained from a source that cannot be named because they are not allowed to speak on behalf of the company."

This field is optional.

11. Select items to link to the current item. Linked items are most important for items of type 'Event' and 'Narrative' because the linked items are displayed in the update stream with the event and narrative text. For example, if you are creating an event and you want to show some photos, videos and quotes with it, you would first create all those items and then link them to the event item from this section. In order to link items, select them from the left list and click on the arrow button in the middle. This will move them to the right list. Everything in the right list will be linked to the current item. You can filter the items in the left list by type to search for the items you want to link.

You can de-link an item by selecting it in the right list and clicking the bottom arrow to move them back to the left list.

In some cases, items can be automatically suggested to you when you save a content item. The type of items that can be automatically suggested are people, organizations and concepts. For example, if you created a "Player" content item for Nancy Pelosi, and then you mention her name in the content of an "Event" item, when you save the event item, you will receive a message asking if you want to link the 'Nancy Pelosi' content item to this event. You can review the suggestions and move them over to the right list in order to accept them and save again.

12. Finally, you can save the content item either as draft or publish it. You can select "Republish, without updating time" for items that you are editing and if you don't want them to rise to the top of the stream again. This can be used for making minor edits to previously published items. Wait for the success confirmation message to make sure the changes were saved.


# Special links within the content #

You can create a number of special types of links within the HTML content of your story summary or your content items. These links are to other content within the story, instead of to external webpages.

These links will not work in the editor or in the preview mode. But you can test them by going to the user-facing living story page. Eg. http://your-hostname/lsps/HealthCare

#### Links to Events and Narratives that appear in the update stream ####

Clicking on these links will scroll the page up or down to that update and expand it. To create such a link,
  1. Select the text in the editor box that you would like to link.
  1. Then click on the 'Go to content entity link' ![http://wiki.living-stories.googlecode.com/hg/insertGoToContentItem.gif](http://wiki.living-stories.googlecode.com/hg/insertGoToContentItem.gif) icon.
  1. Click on the 'Select item' button in the popup window.
  1. Change the 'Content item type:' dropdown to either "Event" or "Narrative" depending on what you want to link.
  1. Click on 'Search'.
  1. Select the item you want to link to from the search results displayed below
  1. Select 'Ok' on the popup

#### Links to Background/Concept items ####

You may wish to link a term in the content to a background writeup or definition. In order to do this, you would first have to create the Background/Concept item. Clicking on such links brings up a small popup window next to the place that was clicked that shows the contents of the background/concept item. User can click anywhere outside the popup window to get rid of it. To create this link:

  1. Select the text in the editor box that you would like to link.
  1. Then click on the 'Insert content popup link' ![http://wiki.living-stories.googlecode.com/hg/insertContentItem.gif](http://wiki.living-stories.googlecode.com/hg/insertContentItem.gif) icon.
  1. Click on the 'Select item' button in the popup window.
  1. Change the 'Content item type:' dropdown to "Background".
  1. Click on 'Search'.
  1. Select the item you want to link to from the search results displayed below
  1. Select 'Ok' on the popup

#### Links to people profiles ####

You can link the name of a person or organization that appears in the text to a writeup of their profile and role in the story. Clicking on such links brings up a small popup window next to the place that was clicked that shows a picture of the player along with a small snippet of their profile information. There is also a link on the popup that can take the user to a page that contains detailed information about the player. User can click anywhere outside the popup window to get rid of it. To create this link:

  1. Select the name of the person or organization in the editor box that you would like to link.
  1. Then click on the 'Insert content popup link' ![http://wiki.living-stories.googlecode.com/hg/insertContentItem.gif](http://wiki.living-stories.googlecode.com/hg/insertContentItem.gif) icon.
  1. Click on the 'Select item' button in the popup window.
  1. Change the 'Content item type:' dropdown to "People".
  1. Click on 'Search'.
  1. Select the item you want to link to from the search results displayed below
  1. Select 'Ok' on the popup

#### Link text to a photo, video or graphic ####

You can also link text to a photo, video, graphic, etc. that you have previously created for the story. Clicking on such a link will bring up a popup that will show the full view of the image, video, graphic, etc. To create such a link:

  1. Select the text in the editor box that you would like to link.
  1. Then click on the 'Insert lightbox link' ![http://wiki.living-stories.googlecode.com/hg/insertLightbox.gif](http://wiki.living-stories.googlecode.com/hg/insertLightbox.gif) icon.
  1. Click on the 'Select item' button in the popup window.
  1. Change the 'Content item type:' dropdown to "Asset".
  1. Change the 'Content entity subtype:' dropdown to the type you are linking.
  1. Click on 'Search'.
  1. Select the item you want to link to from the search results displayed below
  1. Select 'Ok' on the popup