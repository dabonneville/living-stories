# Guide to CSS styles #

Note that basic changes are possible without worrying about the specifics of CSS styles at all.  See the [customization section](UserInterfaceCustomization.md) for more details.

If you want to change the style for a specific widget, look for the `ui:style` block in that widget first.  If you don't see a relevant style there, or if you see that the element in question uses a style from `Resources.java`, then the `LivingStoryPage.css` file is where you should be.

Here is a rundown of some of the more important styles in this file:

  * `linkedItemSpacing` - margin added to the bottom of linked content rendered in the stream view of events and narratives.
  * `substituteHeaderSpacing` - margin added to the top of linked content that doesn't have headers, to prevent uneven spacing (e.g. ImageAssetPreview doesn't have a header, whereas DocumentAssetPreview does)
  * `linkedAtomsPanel` - Style for the right column of linked content shown in the event/narrative stream views.  You can change its size and position by editing this style.
  * `gwt-DisclosurePanel` - Styles used for decorating the toggle pane on the event/narrative stream view.  You can change the background colors for the 'read more..' footer here.
  * `gwt-PopupPanel` - Styles for popup panes in the living story.  You can set the border color, width, and padding here.
  * `page` - Styles for sizing the page content.  Use this to change your page's max/min widths and padding.
  * `summaryHighlights` - Style for the highlighted text in the summary (when content changes).  You can change the style to do something different (change the font color instead of background color, modify the size, etc)
  * `buttonListItem` - Style for the list of themes on the left of the overview page.  Change the background color, border color, and size here.
  * `selectedButtonListItem` - Style for the selected theme.
  * `selectedToolbeltFilter` - Style for selected filters in the left pane of the overview page.
  * `unselectedToolbeltFilter` - Style for non-selected filters.
  * `toolbeltSeparator` - Style for the spacer between filter groups.  Use this to add a horizontal rule, or to change the spacing.
  * `loginPane` - Style for positioning the login link on the start page.
  * `startPageStoryName`, `startPagePublisherName`, `startPageViewAll` - relatively self explanatory; styles for various elements on the start page.
  * `updateText` - Style for the text in the updates on the start page.
  * `lightboxTitle` - Style for the title of the lightbox.
  * `sourceInfoLink` - Style of the link that is shown when a source popup is added
  * `filmstrip-current` - Style for the currently selected image in the slideshow filmstrip.  Use this to change how the element is displayed (border width, style, etc).