# Lab 1-2 Byte Array Streams
### IBM Intermediate Java

---

## Lab Overview

In this lab you will be copying a file via using FileInputStream and FileOutputStream that read and write from a 128 byte buffer by modifying the code from the last lab.


## Part One: Setup

For this lab, you can start with the code as from the last lab. If you don't have that code, it is in the folder _Lab 1-1 src_.

Starting code:

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCopy {
    
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
 
<br/><br/>

## Part Two: Create the Buffer
1. Change the single byte to a 128 size byte array.

2. Add a couple of variables so you can track how many times file reads are done. The `inputCount` variable will count the number of times a buffer full of data is read.

```java
   public static void main(String[] args) throws IOException {
        
            FileInputStream infile = null;
            FileOutputStream outfile = null;

            byte[] b = new byte[128];

            int inputCount = 0;
            int byteCount = 0;
            int bytesRead = 0;
```
3. Since you now reading a chunk of data, the read method will return the number of byes read into the buffer, not the value that was read.

```java
    try{
        infile=new FileInputStream("SampleText.txt");
        outfile=new FileOutputStream("Copy.txt");

        while((bytesRead=infile.read(b))!=-1){
            outfile.write(b);
            byteCount=byteCount+bytesRead;
            inputCount++;'
            System.out.println("inputCount="+inputCount+" bytesRead ="+bytesRead);
        }
    }
```

4. Print out the total number of bytes copied.

```java
 System.out.println(byteCount + " bytes copied");
```
5. Examine the `Copy.txt` file and notice that unlike the previous lab, this code does not replicate the source text. Can you explain this behavior?

---

## DONE!!



