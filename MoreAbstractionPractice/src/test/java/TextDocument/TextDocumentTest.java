package TextDocument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cpsc2150.TextDocument.models.BuilderTextDocument;
import cpsc2150.TextDocument.models.ITextDocument;
import cpsc2150.TextDocument.models.StringTextDocument;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/** A few behavior checks to use while completing the practice. */
public class TextDocumentTest {

  enum Implementation {
    STRING,
    BUILDER
  }

  private ITextDocument createDocument(Implementation implementation, String title) {
    return implementation == Implementation.STRING
        ? new StringTextDocument(title)
        : new BuilderTextDocument(title);
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void newDocumentHasItsTitleAndAnEmptyBody(Implementation implementation) {
    ITextDocument document = createDocument(implementation, "  Lab notes  ");

    assertEquals("  Lab notes  ", document.getTitle());
    assertEquals("", document.readText());
    assertEquals("  Lab notes  \n", document.formatDocument());
    assertEquals("", document.readText());
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void replacementOverwritesTheWholeBodyAndCanClearIt(Implementation implementation) {
    ITextDocument document = createDocument(implementation, "Draft");

    document.replaceText("A much longer original body.");
    assertEquals("A much longer original body.", document.readText());

    document.replaceText("Short");
    assertEquals("Short", document.readText());

    document.replaceText("");
    assertEquals("", document.readText());
    assertEquals("Draft", document.getTitle());
    assertEquals("Draft\n", document.formatDocument());
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void appendingAddsASeparatorOnlyAfterExistingText(Implementation implementation) {
    ITextDocument document = createDocument(implementation, "Shopping");

    document.appendLine("Apples");
    assertEquals("Apples", document.readText());

    document.appendLine("Bread");
    assertEquals("Apples\nBread", document.readText());
    assertEquals("Shopping", document.getTitle());

    document.replaceText("");
    document.appendLine("Tea");
    assertEquals("Tea", document.readText());
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void emptyLinesAndExistingNewlinesArePreserved(Implementation implementation) {
    ITextDocument document = createDocument(implementation, "Lines");

    document.appendLine("");
    assertEquals("", document.readText());

    document.appendLine("First");
    document.appendLine("");
    assertEquals("First\n", document.readText());

    document.appendLine("Second\nThird");
    assertEquals("First\n\nSecond\nThird", document.readText());
    assertEquals("Lines", document.getTitle());
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void formattingPreservesExactTextAndDoesNotChangeTheDocument(Implementation implementation) {
    ITextDocument document = createDocument(implementation, "Report");
    document.replaceText("  Keep these spaces  \nAnd this newline\n");

    assertEquals(
        "Report\n  Keep these spaces  \nAnd this newline\n", document.formatDocument());
    assertEquals(
        "Report\n  Keep these spaces  \nAnd this newline\n", document.formatDocument());
    assertEquals("  Keep these spaces  \nAnd this newline\n", document.readText());
    assertEquals("Report", document.getTitle());
  }

  @ParameterizedTest(name = "{0}")
  @EnumSource(Implementation.class)
  void separateDocumentsAndPreviouslyReadStringsStayIndependent(Implementation implementation) {
    ITextDocument first = createDocument(implementation, "First title");
    ITextDocument second = createDocument(implementation, "Second title");
    first.replaceText("Original");
    String savedText = first.readText();

    second.replaceText("Other body");
    assertEquals("Original", first.readText());

    first.appendLine("Added");
    assertEquals("Original\nAdded", first.readText());
    assertEquals("Other body", second.readText());
    assertEquals("Original", savedText);
    assertEquals("First title", first.getTitle());
    assertEquals("Second title", second.getTitle());
  }
}
