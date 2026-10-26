# Abstraction Practice: Text Documents

## DISCLAIMER:

Disclaimer: Not only is this not a 1-to-1 mirror of what the actual benchmark is going to look like
(although you're doing the same thing with both repos), it's also 90% AI generated, so just be aware of things
like hallucinations or other random nonsense AI likes to do when writing code.

I have at least verified that the code is good practice for B3, just don't come yelling at me if there's some oddity
or that "that practice thing you gave us was real different from the actual benchmark" or anything like that...

By using this repo, you're agreeing that you understand how this should be used and that you know it's AI
generated, meaning it is prone to contain mistakes.

Also, I'm well aware that I didn't provide the solution. I'm not going to either :^)
the proper way to practice is to do it without access to a solution and then you meet with the TAs or I to go over it.
I strongly recommend the TAs or I, and not AI to go over it. Remember, AI doesn't always know the context of the things
I want you to know. It might give something that is objectively correct in the greater scheme of software engineering,
but incorrect based on what I'm assessing you on. Your benchmark grade is about the latter, not the former.

## Context

Complete a small text document model by applying the abstraction and layering ideas from
class. Each document has a fixed title and an editable body. The starter provides an
interface, an abstract class, and two concrete implementations. Your task is to decide where
the five operations belong and implement them while preserving their documented behavior.

## The provided starter

The model files are in `src/main/java/cpsc2150/TextDocument/models/`:

- `ITextDocument.java` declares the public operations and their contracts.
- `AbsTextDocument.java` stores the fixed title.
- `StringTextDocument.java` stores the body in a `String`.
- `BuilderTextDocument.java` stores the body in a `StringBuilder`.

The driver is in `src/main/java/cpsc2150/TextDocument/views/Driver.java`. The practice tests
are in `src/test/java/TextDocument/TextDocumentTest.java`.

Both concrete classes extend `AbsTextDocument`, which implements `ITextDocument`. The fields,
constructors, inheritance relationships, and method signatures are supplied. The project uses
the same Gradle source and test layout as the benchmark.

**The starter intentionally does not compile yet.** The five document operations still need
implementations before you can run the driver or tests.

## Your task

For each of the five operations declared in `ITextDocument`:

1. **Read the entire Javadoc, including its description, precondition, and postcondition.**
2. Decide whether the operation is primary or secondary for the described behavior.
3. Place its implementation at the highest suitable layer: the interface, the abstract class,
   or both concrete classes.
4. Write the implementation and remove any redundant implementation that a class can inherit.

| Method               | Behavior                                                                      |
|----------------------|-------------------------------------------------------------------------------|
| `getTitle()`         | Return the title established when the document was created.                   |
| `formatDocument()`   | Return the title, a newline, and the body without changing the document.      |
| `readText()`         | Return the current body as a `String`.                                        |
| `appendLine(aLine)`  | Extend the body, inserting a newline only when the previous body is nonempty. |
| `replaceText(aText)` | Replace the entire body with the supplied text.                               |

## Document rules

A new document has an empty body, `""`, and its title never changes. Constructor calls will
supply a non-null, nonempty title. Calls to `appendLine` and `replaceText` will supply non-null
arguments. These are preconditions; you do not need to implement or test behavior for invalid
arguments.

Preserve all characters exactly, including spaces and existing newlines. The separator
specified by `appendLine` and `formatDocument` is `"\n"` on every platform. An empty replacement
clears the body. An empty argument to `appendLine` leaves an empty body empty, or adds a newline
to a nonempty body. Formatting always includes the newline after the title, even when the body
is empty.

For example, a document titled `Shopping` has the following behavior. String literals make
the newline characters visible in this table.

| Action                 | Body afterward    | Result of `formatDocument()` |
|------------------------|-------------------|------------------------------|
| Construct the document | `""`              | `"Shopping\n"`               |
| `appendLine("Apples")` | `"Apples"`        | `"Shopping\nApples"`         |
| `appendLine("Bread")`  | `"Apples\nBread"` | `"Shopping\nApples\nBread"`  |
| `replaceText("Tea")`   | `"Tea"`           | `"Shopping\nTea"`            |
| `replaceText("")`      | `""`              | `"Shopping\n"`               |

The class comments describe each storage type and list useful `StringBuilder` operations.

## Constraints

- Keep the supplied names, packages, signatures, fields, constructors, and inheritance
  relationships.
- Do not add fields, public operations, or extra model classes.
- Keep fields private, and do not expose mutable storage through a getter.
- Do not cast an `ITextDocument` reference to a concrete class or use `instanceof` to choose
  different behavior for different implementations.
- **Follow the method contracts**. Behavior and method placement both matter.

## Run the driver and tests

Open the project directory as a Gradle project in IntelliJ and let Gradle finish importing.
Use JDK25, specifically Amazon Corretto 25.0.4; this is required by [JUnit 6](https://docs.junit.org/6.0.0/_exports/junit-user-guide-6.0.0.html).
The Gradle wrapper and JUnit 6.0.0 dependencies are included in the build setup.

After implementing the methods, run `cpsc2150.TextDocument.views.Driver` from the IDE. Each
implementation should print these lines after its heading:

```text
Title: Lab notes
Initially empty: true
After appending:
Lab notes
Mix the paint.
Let it dry.
After replacement:
Lab notes
Use blue paint.
After clearing and appending:
Lab notes
Start again.
```

Run the tests using Gradle's `test` task too if you want to double check you didn't brick any of the implementations.

The first Gradle run downloads the configured Gradle version and test dependencies, so it'll take longer. The test
report is written to `build/reports/tests/test/index.html`.

There are six parameterized tests. Each runs once for `STRING` and once for `BUILDER`, giving
12 test executions. Again, they are only checking that you didn't change the desired implementation in a way that
violates the contract. **THE TESTS DO NOT CHECK WHETHER METHODS ARE IMPLEMENTED IN THE RIGHT FILE OR IF THEY ARE
PROPERLY CLASSIFIED AS PRIMARY OR SECONDARY IN THEIR RESPECTIVE FILE.** 
