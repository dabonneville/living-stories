

# Data Structure Outline #

Here is an outline of the different data types in the format described above and their properties:

<table border='1'>
<tr>
<blockquote><td>
<blockquote><b>Data type</b>
</blockquote></td>
<td width='40%'>
<blockquote><b>Properties</b>
</blockquote></td>
<td width='20%'>
<blockquote><b>Client object location</b>
</blockquote></td>
<td width='20%'>
<blockquote><b>Server entity location</b>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Living Story<br>
</blockquote></td>
<td>
<ul><li>Id<br>
</li><li>Title<br>
</li><li>URL<br>
</li><li>Summary<br>
</li><li>List of themes<br>
</li><li>List of content<br>
</li></ul></td>
<td>
<blockquote>com.google.livingstories.client.LivingStory<br>
</blockquote></td>
<td>
<blockquote>com.google.livingstories.server.dataservices.impl.LivingStoryEntity<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Theme<br>
</blockquote></td>
<td>
<ul><li>Id<br>
</li><li>Name<br>
</li><li>Living story id<br>
</li></ul></td>
<td>
<blockquote>com.google.livingstories.client.Theme<br>
</blockquote></td>
<td>
<blockquote>com.google.livingstories.server.dataservices.impl.ThemeEntity<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Content Element<br>
</blockquote></td>
<td>
<ul><li>Id<br>
</li><li>Living story id<br>
</li><li>Type<br>
</li><li>HTML content<br>
</li><li>Importance<br>
</li><li>Update timestamp<br>
</li><li>Location<br>
</li><li>Source<br>
</li><li>List of contributors<br>
</li><li>List of themes<br>
</li><li>List of associated content elements<br>
</li><li>Optional properties based on type<br>
</li></ul></td>
<td>
<blockquote>com.google.livingstories.client.BaseContentItem<br>
</blockquote></td>
<td>
<blockquote>com.google.livingstories.server.dataservices.impl.BaseContentEntity<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>User<br>
</blockquote></td>
<td>
<ul><li>Id<br>
</li><li>Email address<br>
</li><li>Nickname<br>
</li><li>Is admin<br>
</li><li>Default story view setting<br>
</li><li>List of living story data:<br>
<ul><li>living story id<br>
</li><li>last visit time<br>
</li><li>is subscribed to email<br>
</li></ul></li></ul></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>com.google.livingstories.server.dataservices.impl.UserEntity<br>
</blockquote></td>
</tr>
</table></blockquote>

Content elements can exist without having a living story id. There are certain types of content elements that are general and don't belong to a particular living story, but can be used in multiple. A good example of this are people. People can play a role in multiple stories. So they can have a general entity that doesn't have a living story id that describes them in general and then another story-specific entity for a particular story they are playing a role in that talks more about their role in that story. Another category of people who won't have a living story id are contributors because they can contribute to multiple stories.


# Content Types #

The Content Items can be of various different types and other than the common properties described in the table above, they have some special properties depending on the type.
<table border='1'>
<tr>
<blockquote><td>
<blockquote><b>Content type</b>
</blockquote></td>
<td>
<blockquote><b>Explanation</b>
</blockquote></td>
<td>
<blockquote><b>Types</b>
</blockquote></td>
<td>
<blockquote><b>Other properties</b>
</blockquote></td>
<td>
<blockquote><b>What does the "HTML content" field contain for this type?</b>
</blockquote></td>
<td>
<blockquote><b>Notes and special behaviors</b>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Event<br>
</blockquote></td>
<td>
<blockquote>A development in the story<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<ul><li>Update<br>
</li><li>Summary<br>
</li><li>Start date<br>
</li><li>End date (optional)<br>
</li></ul></td>
<td>
<blockquote>Details of the development that don't fit into any of the other content types.<br>
</blockquote></td>
<td>
<blockquote>Always displayed in the main update stream. Appears as "News" in the filter column.<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Narrative<br>
</blockquote></td>
<td>
<blockquote>A long-form piece that expresses an opinion or investigates an issue. May or may not be tied to a particular new development in the story.<br>
</blockquote></td>
<td>
<ul><li>Feature<br>
</li><li>Analysis<br>
</li><li>Investigation<br>
</li><li>Profile<br>
</li><li>Editorial<br>
</li><li>Op-Ed<br>
</li><li>Letter to the  editor<br>
</li><li>Review<br>
</li><li>Column<br>
</li><li>Op Ed Column<br>
</li></ul></td>
<td>
<ul><li>Headline<br>
</li><li>Summary<br>
</li><li>Date<br>
</li></ul></td>
<td>
<blockquote>The full body text of the narrative.<br>
</blockquote></td>
<td>
<blockquote>Displayed as an update in the stream if it is not linked from any other event or narrative. If it is linked from another event or narrative, then it is displayed within the block of the containing element and not as a top-level update in the main stream.</blockquote></blockquote>

<blockquote>Content of this type is divided into 2 filters on the story page: "Features" and "Opinion". Narratives of types Editorial, Op-Ed, Letter to the editor, and Op-Ed Column are considered 'Opinion' and the rest are 'Features'.<br>
</blockquote><blockquote></td>
</tr>
<tr>
<td>
<blockquote>Background<br>
</blockquote></td>
<td>
<blockquote>Information not directly related to the story, but essential for understanding the context. Can also be used for concepts that are important to understanding the significance of the story.<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<ul><li>Concept<br>
</li><li>Name (optional)<br>
</li></ul></td>
<td>
<blockquote>The text of the background or explanation of the concept.<br>
</blockquote></td>
<td>
<blockquote>If a concept name is assigned to the background element, the concept name is auto-linked in the HTML content of all other content. If the user clicks on the concept name wherever it appears on the story page, they are shown a pop-up with the text of the concept.<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Asset<br>
</blockquote></td>
<td>
<blockquote>Multimedia, documents and external links.<br>
</blockquote></td>
<td>
<ul><li>Image<br>
</li><li>Video<br>
</li><li>Audio<br>
</li><li>Graphic<br>
</li><li>Document<br>
</li><li>Link<br>
</li></ul></td>
<td>
<ul><li>Caption<br>
</li><li>Preview image URL<br>
</li></ul></td>
<td>
<blockquote>The HTML to render the video, audio, link, document, etc.</blockquote></blockquote>

<blockquote>Except for images, where the HTML content should just be a URL to the full image.<br>
</blockquote><blockquote></td>
<td>
<blockquote>The preview images for photos, video and graphics are shown in the stream and multimedia filtered views. Clicking on them opens a lightbox that shows the full version.<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Player<br>
</blockquote></td>
<td>
<blockquote>A person or organization that is playing an important role in the story.<br>
</blockquote></td>
<td>
<ul><li>Person<br>
</li><li>Organization<br>
</li></ul></td>
<td>
<blockquote>If there is no story id:<br>
</blockquote><ul><li>Name<br>
</li><li>Aliases<br>
</li><li>Photo</li></ul></blockquote>

<blockquote>If there is a story id:<br>
</blockquote><ul><li>Parent player entity id<br>
</li></ul><blockquote></td>
<td>
<blockquote>If there is no story id, it represents general bio or profile information for a person or organization.</blockquote></blockquote>

<blockquote>If there is a story id, it represents an explanation of the specific role that the person or organization is playing in that story.<br>
</blockquote><blockquote></td>
<td>
<blockquote>Also used to represent authors, photographers and contributors in the system. The player entities for contributors don't have an assigned living story.</blockquote></blockquote>

<blockquote>A player with a living story id always has to have a parent player entity assigned that has no living story id. The players for stories inherit properties such as names, aliases and photo from the parent.</blockquote>

<blockquote>Names of players are automatically linked in the content. Clicking on the name brings up a pop-up with a brief explanation of their role in the story. And a link to take the user to a page that gives the full bio information about that player along with other content related to them.<br>
</blockquote><blockquote></td>
</tr>
<tr>
<td>
<blockquote>Reaction<br>
</blockquote></td>
<td>
<blockquote>The reaction of a person or group to a new development in the story.<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>Content of the reaction<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Quote<br>
</blockquote></td>
<td>
<blockquote>A direct or indirect quote.<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>Content of the quote along with who said it<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
</tr>
<tr>
<td>
<blockquote>Data/Fact<br>
</blockquote></td>
<td>
<blockquote>Numerical data or facts associated with the story.<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
<td>
<blockquote>HTML for how the data should be rendered.<br>
</blockquote></td>
<td>
<blockquote>-<br>
</blockquote></td>
</tr>
</table>