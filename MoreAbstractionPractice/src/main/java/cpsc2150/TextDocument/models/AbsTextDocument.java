package cpsc2150.TextDocument.models;

/**
 * Provides the construction and shared state used by the supplied document implementations.
 */
public abstract class AbsTextDocument implements ITextDocument {

  private final String title; // Do not change this to protected or public.

  /**
   * Initializes the fixed document title, preserving the supplied characters exactly.
   * @param aTitle the nonempty title of the document
   * @pre aTitle != null AND aTitle is not empty
   * @post title = aTitle
   */
  protected AbsTextDocument(String aTitle) {
    this.title = aTitle;
  }

  // TODO: Add any method implementations that belong at this layer, should any exist.

  public String getTitle() {
    return title;
  }
}
