package cpsc2150.TextDocument.views;

import cpsc2150.TextDocument.models.BuilderTextDocument;
import cpsc2150.TextDocument.models.ITextDocument;
import cpsc2150.TextDocument.models.StringTextDocument;

/** Demonstrates both document implementations through the same interface. */
public class Driver {


  public static void main(String[] args) {
    ITextDocument stringDocument = new StringTextDocument("Lab notes");
    ITextDocument builderDocument = new BuilderTextDocument("Lab notes");

    System.out.println("String implementation:");
    showExample(stringDocument);

    System.out.println();
    System.out.println("StringBuilder implementation:");
    showExample(builderDocument);
  }

  /**
   * Demonstrates reading, appending, replacing, clearing, and formatting a document.
   *
   * @param document a fresh document titled "Lab notes"
   * @pre document != null AND document.getTitle() equals "Lab notes" AND
   *     document.readText() is empty
   * @post document.getTitle() equals "Lab notes" AND document.readText() equals
   *     "Start again." AND the results have been printed
   */
  private static void showExample(ITextDocument document) {
    System.out.println("Title: " + document.getTitle());
    System.out.println("Initially empty: " + document.readText().isEmpty());

    document.appendLine("Mix the paint.");
    document.appendLine("Let it dry.");
    System.out.println("After appending:");
    System.out.println(document.formatDocument());

    document.replaceText("Use blue paint.");
    System.out.println("After replacement:");
    System.out.println(document.formatDocument());

    document.replaceText("");
    document.appendLine("Start again.");
    System.out.println("After clearing and appending:");
    System.out.println(document.formatDocument());
  }
}
