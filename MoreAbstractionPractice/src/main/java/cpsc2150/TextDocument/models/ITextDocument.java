package cpsc2150.TextDocument.models;

/**
 * Represents a document with a fixed title and an editable text body.
 * <p>
 * A new document has an empty body. The title never changes, and edits preserve the supplied
 * characters exactly, including spaces and newlines. A String-based document starts with an
 * empty String, while a StringBuilder-based document starts with a builder containing no
 * characters.
 * <p>
 * In the contracts below, self means the entire document, and #self means its state before
 * the method call. A leading # on an expression refers to its value before the call; for
 * example, #readText() means the previous body. Equality between Strings means equal contents.
 */
public interface ITextDocument {

  /**
   * Reports the document's fixed title, exactly as supplied when the document was created.
   * Editing or clearing the body does not change this title.
   * @return the title established by the constructor
   * @pre none
   * @post getTitle = the title established when the document was created AND self = #self
   */
  String getTitle();

  /**
   * Produces a displayable version of the document containing its title, one newline, and
   * its complete current body, in that order. The separator is included even when the body
   * is empty. No spaces or newlines are removed, and no additional characters are added.
   * This operation returns the formatted text without printing it or changing the document.
   * @return the title and body separated by exactly one additional newline
   * @pre none
   * @post formatDocument = getTitle() + "\n" + readText(), including the separator when
   *     readText() is empty, AND self = #self, without modifying the state of self at any
   *     point during the call, even transitively
   */
  default String formatDocument() {
    return getTitle() + "\n" + readText();
  }

  /**
   * Reports the complete sequence of characters currently in the body, without including
   * the title or adding formatting. An empty body produces an empty String. The returned
   * String describes the body at the time of the call and remains unchanged by later edits.
   * Reading the body must not temporarily change and then restore any part of the document.
   * @return the current body as a non-null String
   * @pre none
   * @post readText = the current body, preserving every character in its original order,
   *     done without modifying the state of self at all, even transitively, AND self = #self
   */
  String readText();

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
  void appendLine(String aLine);

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
  void replaceText(String aText);
}
