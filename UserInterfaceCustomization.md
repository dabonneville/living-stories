

# Basic Customization #

## Basic styles ##

You can change the overall appearance of the page by editing the 'com/google/livingstories/client/lsps/views/Constants.css' file.  See the following for an explanation of each constant value:

`defaultFontFamily` - The default font face for text on the page.
<br />
`defaultFontSize` - The default size for text on the page.
<br />
`defaultLineHeight` - The default amount of vertical space to allocate for lines of text.
<br />
`primaryBackgroundColor` - The default background color for the page.
<br />
`secondaryBackgroundColor` - The background color for special elements (such as headers)
<br />
`highlightColor` - The color used to highlight changes in the summary text
<br />
`defaultBorderColor` - The color to use for borders and separators
<br />
`selectedBorderColor` - The color used to indicate a selected item.  Currently only used in the slideshow filmstrip.
<br />
`primaryLinkColor` - The default color for links
<br />
`secondaryLinkColor` - The color for secondary links (such as 'Read more', 'Show less', etc.)
<br />
`fadedLinkColor` - The color to use for primary links in the 'already read' state.
<br />
`primaryTextColor` - The default color for text
<br />
`secondaryTextColor` - The color for secondary text (such as update count, info labels, etc.)
<br />
`fadedTextColor` - The color to use for text in the 'already read' state.
<br />
`errorTextColor` - The color used for error text.

# Intermediate Customization #

You can do further customization of the look and feel by editing the CSS styles directly.  You may want to read up on our [package structure](GuideToModules.md) for help on finding the right files to look at.

In most situations, the styles you'll be interested in will live in the UiBinder template of the corresponding widget, somewhere under the `com/google/livingstories/client/lsp/views` directory.  However, there are some legacy styles and more general style which are located in `com/google/livingstories/client/lsp/views/LivingStoryPage.css`.  Read the [guide to CSS styles](GuideToCss.md) for an explanation of the styles you'll find in this file.

For example, to change the way the living story title is rendered, go to `com/google/livingstories/client/lsp/views/OverviewPage.ui.xml`, and edit the `title` style in the `ui:style` element.


# Advanced Customization #

If just editing CSS is not customizable enough, we have built some flexibility into the system using the GWT templating language known as UiBinder.  This allows someone with moderate knowledge of HTML and UiBinder to move page elements around with relative ease.

Again, familiarity with our [package structure](GuideToModules.md) is helpful here.  All of the UiBinder classes for the living story page can be found in `com/google/livingstories/client/lsps/views` and its subdirectories.  Each UiBinder template has a ui.xml template file as well as a .java file to back it.  The beauty of UiBinder is that you can move things around in the template file without worrying about the code that implements the behaviors of that element in the java file.

For example, if we wanted to swap the positions of the filters and the right-hand timeline, all we need to do is go to `OverviewPage.ui.xml`, look in the second `table` element, and swap the contents of the first (ThemeListWidget and FilterWidget) and third (AnchoredPanel) table cells in that table.  The code that backs this template will still be able to find these elements and populate them correctly, but their position in the overall HTML will be reversed.

# Customizing UI Text #

Do you want to change some of the fixed strings that appear in the application UI? You can actually do this without writing code by using the localization mechanism.

Read more on [Internationalization](Internationalization.md) first. Here's the trick: rather than using the default .properties file for your English strings, you can provide an `_`en.properties file override: this override will apply instead.

For example, if you want the "Read more..." links in your application to read "Only a fool would not read this!" instead, create a file at src/com/google/livingstories/client/lsp/LspConstants\_en.properties with the following contents

```
readMore = Only a fool would not read this!
```


# Logo #

To specify the image file to be used as the logo (displayed on the top left of the pages), put it in the `war/images` directory. Then enter the file name in the `/war/WEB-INF/externalServiceKeys.properties` file for the `logoFileName` key. More information about specifying properties in this file is [here](http://code.google.com/p/living-stories/wiki/ExternalServices).