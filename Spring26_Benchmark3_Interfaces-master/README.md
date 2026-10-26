## Spring26 - Benchmark 3 - Interfaces and Default Methods

Your job for this benchmark is to do the following:
1. evaluate whether the methods within IBag.java are primary or secondary
2. update IBag.java to reflect your evaluations by adding the `default` keyword to secondary methods
3. implement the default methods in IBag.java
4. implement the primary methods in ArrayListBag.java and LinkedListBag.java

READ THE DOCUMENTATION. Even if you've seen this method before as either primary or secondary,
the main implementation may differ from what you've seen before which could change your evaluation.

There shouldn't be any need to add any new methods. Definitely don't remove any methods...

## Notes / Tips

You have two extra methods in ArrayListBag and LinkedListBag that are not in IBag. **iterator()** comes from the
iterable interface. The only thing you need to know about the iterable interface is that, in order to use a for-each
loop on something, it must implement this interface. This _could_ be useful for some of your implementations...
Then there's toString. That's just for the autograder's Junit tests.

Everything must compile! If it doesn't compile it's an auto zero.

Both the contracts cheat-sheet and the IntelliJ cheat-sheet may be helpful for this benchmark.

Pay close attention to the private data variables from the two implementing classes. Both are implementations of the List
interface. They're even called the same thing... Committing a 'cardinal sin of programming' might save you some time here
so long as you do it properly...

## Submission

When you are done, submit your changes to Gradescope. YOU MUST ONLY SUBMIT THE FOLLOWING FILES:
- IBag.java
- ArrayListBag.java
- LinkedListBag.java

Submitting anything other than these three files will crash the autograder.

Submission portal: https://www.gradescope.com/courses/1224352/assignments/7868691