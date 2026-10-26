package cpsc2150.TextDocument.models;

/**
 * Stores the document body in a String.
 * <p>
 * Remember that Strings are immutable: a String's characters do not change. A variable
 * referring to a String can be assigned a different String. The text field always refers
 * to the document's entire current body, including any spaces and newlines.
 */
public class StringTextDocument extends AbsTextDocument {

  private String text;

  /**
   * Creates a document with the supplied title and an empty body.
   * @param aTitle the nonempty title of the document
   * @pre aTitle != null AND aTitle is not empty
   * @post getTitle() = aTitle AND text = "", representing a body with no characters
   */
  public StringTextDocument(String aTitle) {
    super(aTitle);
    text = "";
  }

  // TODO: Add any method implementations that belong at this layer.

  @Override
  public String readText() {
    return text;
  }

  /**
   * Extends the body with the supplied text, separating it from an existing nonempty body
   * with exactly one additional newline. If the body is empty, the supplied text becomes
   * the whole body without a leading newline. Existing spaces and newlines are preserved,
   * including a newline already at the end of the body. An empty argument leaves an empty
   * body empty, or adds a newline to a nonempty body. The title is unchanged.
   *
   * @param aLine the text to append; it may be empty or contain newlines
   * @pre aLine != null
   * @post if #readText() is empty, readText() = aLine; otherwise,
   *     readText() = #readText() + "\n" + aLine; in either case,
   *     getTitle() = #getTitle() AND all characters of the previous body and aLine are
   *     preserved in order, with only the specified separator added
   */
  @Override
  public void appendLine(String aLine) {
    if (!text.isEmpty() && !aLine.isEmpty()) {
      text = text + "\n" + aLine;
    } else if (text.isEmpty() && !aLine.isEmpty()) {
      text = text + aLine;
    } else if (!text.isEmpty() && aLine.isEmpty()) {
      text = text + "\n";
    }
  }

  /**
   * Replaces the entire body with the supplied text. None of the previous body remains
   * unless those characters also occur in the replacement. Replacing a long body with a
   * shorter one leaves no old characters at the end, and an empty replacement clears the
   * body. Preserve the supplied text exactly, including spaces and newlines, while keeping
   * the document's title unchanged.
   * @param aText the replacement body; an empty String clears the body
   * @pre aText != null
   * @post readText() = aText AND getTitle() = #getTitle() AND the body contains exactly
   *     the characters of aText in their original order, with no extra characters from
   *     #readText()
   */
  @Override
  public void replaceText(String aText) {
    text = aText;
  }
}
