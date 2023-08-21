# Lab 1-4 Biffered IO
### IBM Intermediate Java

---

## Lab Overview

In this lab, we will modify the first lab to read and write a file character by character using the `FileReader` and `FileWriter` interfaces

## Part One: Setup

Start with the code frm the first lab. It is in the `Lab 1-1 src` directory. Note that the name of the class has been changed from `ByteCopy` to `CharCopy`

Go back to either of the `ByteCopy` labs, record the number of bytes copied.  It should be `4489`
Starter code:

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CharCopy {
    
	public static void main(String[] args) throws IOException {
		FileInputStream infile = null;
		FileOutputStream outfile = null;
		byte b = 0;
		int byteCount = 0;
		
		try {
			infile = new FileInputStream("SampleText.txt");
			outfile = new FileOutputStream("Copy.txt");
			
			while ((b = (byte)infile.read()) != -1) {
				outfile.write(b);
				byteCount++;
			}
            
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			infile.close();
			outfile.close();
		}
        System.out.println(byteCount + " bytes copied");
	}
}
```
## Change the Code

The first code change is to convert it IO classes to `FileReader` and `FileWriter` and to use the variables `c` to hold a character. We are not using a `char` type since the interface returns an `int`. The variable `charCount` records the number of characters processed

```java
 	public static void main(String[] args) throws IOException {
		
		FileReader infile = null;
		FileWriter outfile = null;
		int c = 0;
		int charCount = 0;
```

We can't just open text file anymore without knowing how it's encoded. We are specifying here that the input and output files will be UTF-8 encoded. If we do not supply an encoding, it will default to whatever your platform defaults to. Normally this is UTF-8 but it could also be ASCII or anything else.

Othewise it works the same as for the `ByteCopy` class. The difference is that the `FileReader` and `FileWriter` classes handle the mapping from byte to code point or character and back again.

```java
		try {
			infile = new FileReader("SampleText.txt", StandardCharsets.UTF_8);
			outfile = new FileWriter("Copy.txt", StandardCharsets.UTF_8);
			
			while ((c = infile.read()) != -1) {
				outfile.write(c);
				charCount++;
				
			}
			
		    } catch (IOException e) {
			    System.out.println(e);
			
		    } finally {
			    if (infile != null) infile.close();
			    if (outfile != null) outfile.close();
			
        }
        System.out.println(charCount + " characters copied");
	}
```

The last line prints out the number of characters. In this case, the 4899 bytes is 2512 characters.

## Optional Section

The following code is the character equivalent to the byte stream array. We will not do this in class but you can try on your own

```java
package iolab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

public class CharCopy {
	

	public static void main(String[] args) throws IOException {
		
		FileReader infile = null;
		FileWriter outfile = null;
		
		char [] c = new char[128];
		
		int charCount = 0;
		int charsRead = 0;
		int readCount = 0;
		
		try {
			infile = new FileReader("SampleText.txt", StandardCharsets.UTF_8);
			outfile = new FileWriter("Copy.txt", StandardCharsets.UTF_8);
			
			while ((charsRead = infile.read(c)) != -1) {
				outfile.write(c);
				
				charCount = charCount + charsRead;
				readCount++;
				System.out.println("Read " + readCount + " Chars read " + charsRead);
				
			}
			
		} catch (IOException e) {
			System.out.println(e);
			
		} finally {
			if (infile != null) infile.close();
			if (outfile != null) outfile.close();
			
		}
        System.out.println(charCount + " characters copied");
	}

}


```


---
## DONE!!



