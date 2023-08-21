# Lab 1-4 Buffered IO
### IBM Intermediate Java

---

## Lab Overview

In this lab, you will implement a BufferedReader and BufferedWriter to perform the same file copy that you did in the previous labs.od.


## Part One: Setup

1. Create a new Java project and copy the same `SampleText.txt`` file that you have been using in the previous labs into the root directory of the project.<br/>
2. Create a package named `iolab`
Create a class named `LineCopy` with a `main()` method.
3. Copy the `SampleText.txt` file as before to the root of the project.

<br/><br/>

## Part Two: Implementing the Code

The buffered forms of `FileReader` and `FileWriter` take objects of these types and add buffering capabilities.  We also need a `String` variable to hold the input string.

```java
public static void main(String[] args) throws IOException {
		
	FileReader infile = null;
	FileWriter outfile = null;
	BufferedReader inbuff = null;
	BufferedWriter outbuff = null;
		
	String line = null;
```

Create the buffered reader and writer.


```java
try {
	infile = new FileReader("SampleText.txt", StandardCharsets.UTF_8);
	inbuff = new BufferedReader(infile);
	outfile = new FileWriter("Copy.txt", StandardCharsets.UTF_8);
	outbuff = new BufferedWriter(outfile);

```
Now read a line at a time until the end of the file. When writing the output, remember that the input reader only reads up to the end of line character so it is not in the input buffer. It has to be added when we output the file.

```java
try {
	infile = new FileReader("SampleText.txt", StandardCharsets.UTF_8);
	inbuff = new BufferedReader(infile);
	outfile = new FileWriter("Copy.txt", StandardCharsets.UTF_8);
	outbuff = new BufferedWriter(outfile);
			
	while ((line = inbuff.readLine()) != null) {
		outbuff.write(line);
		outbuff.newLine();
		System.out.println("Line = "+ line) ;
	}

```

Close the files but be sure to flush the output buffer before you do.

```java
try {
	infile = new FileReader("SampleText.txt", StandardCharsets.UTF_8);
	inbuff = new BufferedReader(infile);
	outfile = new FileWriter("Copy.txt", StandardCharsets.UTF_8);
	outbuff = new BufferedWriter(outfile);
	
	while ((line = inbuff.readLine()) != null) {
  	outbuff.write(line);
		outbuff.newLine();
		System.out.println("Line = "+ line) ;
		}
			
} catch (IOException e) {
	System.out.println(e);
	
} finally {
	outbuff.flush();
	if (inbuff != null) inbuff.close();
	if (outbuff != null) outbuff.close();	
}

```

Run the code and ensure it works.

---
## DONE!!



