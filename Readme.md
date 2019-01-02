### Magic Numbers

There are two wizards, one good and one evil. The evil wizard has captured the princess. The only way to defeat the evil wizard is to recite a set of magic numbers. 

The good wizard has given you two numbers, A and B. Find every magic number between A and B, inclusive. 

A magic number is a number that has two characteristics: 
- No digits repeat. 
- Beginning with the leftmost digit, take the value of the digit and move that number of digits to the right. Repeat the process again using the value of the current digit to move right again. Wrap back to the leftmost digit as necessary. A magic number will visit every digit exactly once and end at the leftmost digit. 

For example, consider the magic number 6231. Start with '6'. Advance 6 steps to '3', wrapping around once. From '3', advance to '2'. From '2', advance to '1'. From '1', advance to '6'. 

- Input: The input consists of two integers on a line, separated by spaces. Each integer A and B is 1 <= A <= B <= 10000. 
- Output: Print each magic number between A and B, inclusive, on a line. If there is no magic number between A and B, print -1. 

- Test Input: 100 1000 
- Expected Output: 147 174 258 285 417 471 528 582 714 741 825 852

### N-Grams

Your task is to build a type-ahead feature for an upcoming product. When the user enters a word or set of words, we want to be able to "predict" what they're going to type next with some level of accuracy. We've chosen to implement this using the N-Gram algorithm defined here http://en.wikipedia.org/wiki/N-gram. 

Your program should return a tuple of predictions sorted high to low based on the prediction score (up to a maximum of three decimal places, or pad with zeroes up to three decimal places i.e. 0.2 should be shown as 0.200), (if predictions share the same score, they are sorted alphabetically.) Words should be split by whitespace with all non-alphanumeric characters stripped off the beginning and end. Prediction scores are calculated like this: Occurrences of a word after an N-gram / total number of words after an N-gram e.g. 

An N-gram of length 2: ONE TWO ONE TWO THREE TWO THREE "TWO" has the following predictions: THREE:0.666,ONE:0.333 "THREE" occurred 2 times after a "TWO" and "ONE" occurred 1 time after a "TWO", for a total of 3 occurrences after a "TWO". 

Your program will run against the following text. You may hardcode it into your program: Mary had a little lamb its fleece was white as snow; And everywhere that Mary went, the lamb was sure to go. It followed her to school one day, which was against the rule; It made the children laugh and play, to see a lamb at school. And so the teacher turned it out, but still it lingered near, And waited patiently about till Mary did appear. "Why does the lamb love Mary so?" the eager children cry;"Why, Mary loves the lamb, you know" the teacher did reply. 

- Input: Your program should read lines of text from standard input. Each line contains a number followed by a string, separated by a comma. The number is the n-gram length. The string is the text from the user. You will be predicting the text following this string. 
- Output: For each line of input print a single line to standard output which is the predictions for what the user is going to type next. 

- Test Input 2,the 
- Expected Output lamb,0.375;teacher,0.250;children,0.125;eager,0.125;rule,0.125
