import java.io.*;
import java.util.Scanner ;
public class Project4
{
public static void main(String[] args)
{
Scanner scan = new Scanner(System.in);
PrintWriter outputStream = null;
Scanner inputStream = null;
System.out.println("Please enter the name of the existing file: ");
String fileName = scan.nextLine();
System.out.println("Please enter the name of the new file: ");
String fileName2 = scan.nextLine();
File fileObject = new File(fileName) ;
File fileObject2 = new File(fileName2);
if(fileObject.exists())
{
if(fileObject2.exists())
{
System.out.println("Choose from the following choices: ");
System.out.println("1 - Exit the program.");
System.out.println("2 - Overwrite the existing file");
System.out.println("3 - Enter a new name for the file");
System.out.println("Enter a number: ");
int choice = scan.nextInt();
if(choice == 1)
{
System.out.println("Exiting program");
System.exit(0);
}
if(choice == 2)
{
System.out.println("Overwriting " + fileName2);
try
{
inputStream = new Scanner(new File(fileName));
outputStream = new PrintWriter(fileName2);
while(inputStream.hasNextLine())
{
String input = inputStream.nextLine();
outputStream.print(input);
}
inputStream.close();
outputStream.close();
}
catch(Exception e)
{
System.out.println("Error");
}
}
if(choice == 3)
{
System.out.println("Enter a new name for the new file: ");
String newName = scan.nextLine();
try
{
inputStream = new Scanner(new File(fileName));
outputStream = new PrintWriter(newName);
System.out.println("Copying " + fileName + " into " + newName);
while(inputStream.hasNext())
{
String input = inputStream.nextLine();
outputStream.println(input);
}
inputStream.close();
outputStream.close();
}
catch(FileNotFoundException e)
{
System.out.println("Error");
System.exit(0);
}
}
}
else
{
try
{
inputStream = new Scanner(new File(fileName));
outputStream = new PrintWriter(fileName2);
while(inputStream.hasNextLine())
{
String input = inputStream.nextLine();
outputStream.println(input);
System.out.println("Copying " + fileName + " into " + fileName2);
}
inputStream.close();
outputStream.close();
}
catch(Exception e)
{
e.printStackTrace();
System.exit(0);
}
}
}
else
{
System.out.println(fileName + " does not exist.");
System.exit(0);
}
}
}