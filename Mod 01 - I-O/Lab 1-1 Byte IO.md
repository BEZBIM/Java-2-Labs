# Lab 1-1 Byte IO
### IBM Intermediate Java

---

## Lab Overview

This is the first lab that explores the file stream interface in Java. Each lab in this series builds on the previous ones so at the ent of each lab, save your work so you can just add new code in each lab.

The primary activity in this lab is copying a file byte by byte using `FileInputStream` and `FileOutputStream`


## Part One: Setup

1. Create a Java Project with a package called iolab.
  <br/>
2. Copy the sample data `test.txt` file from the lab resources folder into the root of the project directory. Make sure that it is the foor of the project directory and _not_ the root of the `src` directory. If you put it into any other location, your code will not be able to find it and will throw an `IOException` when an attempt is made to open it.
  <br/>
  <br/>
3. You can create your own file to use as sample input, but you should ensure that it is a `UTF-8` encoded file if you want to use it in the next lab
  <br/>
  <br/>
<sub>Note: that the output file will not be visible in the project explorer since it is not added to the list of files tracked by the project manifest when it is created. To see your output file, you have to look at the project directory with the Windows file explore
</sub>





