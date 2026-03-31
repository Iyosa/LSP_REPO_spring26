resources:

geeksforgeeks: 
https://www.geeksforgeeks.org/java/classes-objects-java/
https://www.geeksforgeeks.org/java/java-util-hashmap-in-java-with-examples/

gemini: 
AI to troubleshoot shell environment configuration and manual compilation paths.

Gemini said
This midterm for CSCI 363 / CSCI 540 at Howard University is comprehensive, covering Java implementation, Object-Oriented Design (OOD) evaluation, and Design Patterns.
+1

Since your instructor, Bernard P. Woolfolk, explicitly allows the use of AI, notes, and the internet, you have a great toolkit to work with. Just remember that any help I provide must be documented in your development logs with the full transcript.
+4

Here is your checklist to ensure you hit every requirement for a perfect score.

📋 General Requirements
[ ] Package Structure: Ensure every file is in its correct package.
+3

[ ] Javadoc: All classes and public methods must have Javadoc comments including descriptions, @param, and @return.
+2

[ ] GitHub: Push your code "early and often." Only what is on GitHub at the end of class is graded.
+1

🛠️ Question 1: Task Management System (40 pts)
Implementation
[ ] Task.java:

[ ] Default status is "OPEN".

[ ] setStatus(): Must set to "UNKNOWN" if the input isn't OPEN, IN_PROGRESS, or COMPLETE.

[ ] toString(): Matches format T1 Write report [OPEN].

[ ] TaskManager.java:

[ ] Select a data structure that prevents duplicate IDs (e.g., HashMap<String, Task>).
+1

[ ] addTask(): Throws IllegalArgumentException if the ID already exists.

[ ] findTask(): Returns null if the ID is not found.

[ ] getTasksByStatus(): Returns a List<Task>.

[ ] Driver.java: Use the provided code without modification.
+1

Documentation (Package: ...midterm.crccards.doc)
[ ] development_log.md: Include this full chat transcript.
+1

[ ] crccards.md: Explain in 2-3 sentences why TaskManager collaborates with Task but not vice versa.

🧐 Question 2: OOD Evaluation (30 pts)
Documentation (Package: ...midterm.design.doc)
[ ] evaluation.md: Identify issues like poor encapsulation (public fields) and violation of Single Responsibility Principle.
+2

[ ] design.md: Provide new CRC cards (Class, Responsibilities, Collaborators) to fix the design.
+1

[ ] development_log_q2.md: Document resources used for this specific question.

🏗️ Question 3: Strategy Pattern (30 pts)
Implementation (Package: ...midterm.strategy)
[ ] Create a DiscountStrategy interface.
+1

[ ] Implement concrete strategies: RegularDiscount, MemberDiscount, VIPDiscount, and HolidayDiscount.
+1

[ ] Refactor PriceCalculator to accept and use a strategy.

[ ] Driver.java: Must produce the specific output for a $100.0 purchase price.
+1

Documentation (Package: ...midterm.strategy.doc)
[ ] design_evaluation.md: Explain why the original if-else chain was hard to maintain.

[ ] development_log_q3.md: Document resources used for this specific question.

Would you like me to start by generating the Javadoc-compliant code for the Task and TaskManager classes?

You said
give me the code for the task class, use a hashmap for taskmanager do not add any unnesacary comments and keep the comments as concise as possible

Gemini said
Implementation of Task and TaskManager
Following the midterm requirements, here is the implementation for the first two classes. Per your instructions, a HashMap is used in the TaskManager to ensure O(1) lookup times and to easily prevent duplicate task IDs.
+2

Task.java

Package: org.howard.edu.lsp.midterm.crccards 

Java
package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the management system.
 * Author: [Your Name]
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with default status OPEN.
     * @param taskId Unique identifier
     * @param description Task details
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN"; // [cite: 30]
    }

    /** @return The task ID */
    public String getTaskId() { return taskId; }

    /** @return The task description */
    public String getDescription() { return description; }

    /** @return The current status */
    public String getStatus() { return status; }

    /**
     * Updates status. Sets to UNKNOWN if input is invalid.
     * @param status New status value
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN"; // [cite: 41]
        }
    }

    /** @return Formatted string: taskId description [status] */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]"; // [cite: 37]
    }
}
TaskManager.java

Package: org.howard.edu.lsp.midterm.crccards 

Java
package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects using a HashMap.
 * Author: [Your Name]
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>(); // [cite: 44]

    /**
     * Adds a task. Throws exception if ID exists.
     * @param task Task to add
     * @throws IllegalArgumentException if taskId is duplicate
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID detected."); // [cite: 57]
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Locates task by ID.
     * @param taskId ID to search for
     * @return Task object or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId); // [cite: 58]
    }

    /**
     * Retrieves all tasks with a specific status.
     * @param status Status to filter by
     * @return List of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }
        return result; // [cite: 54]
    }
}
You said
Microsoft Windows [Version 10.0.26200.8039]

(c) Microsoft Corporation. All rights reserved.



C:\Users\kimie\Large Scale Programming\src\org\howard\edu\lsp\midterm> cmd /C ""C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot\bin\java.exe" --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -cp C:\Users\kimie\AppData\Roaming\Code\User\workspaceStorage\23b02a0aa4f9601f85b9098a3f258fb0\redhat.java\jdt_ws\jdt.ls-java-project\bin org.howard.edu.lsp.midterm.crccards.Driver "

Exception in thread "main" java.lang.Error: Unresolved compilation problems: 

        TaskManager cannot be resolved to a type

        TaskManager cannot be resolved to a type



        at org.howard.edu.lsp.midterm.crccards.Driver.main(Driver.java:9)



C:\Users\kimie\Large Scale Programming\src\org\howard\edu\lsp\midterm>

Gemini said
It looks like a classic Java classpath or compilation error. The JVM is trying to run your Driver class, but it can't "see" the TaskManager class even though they are in the same package. 
+2

Based on your terminal output, here is how to fix it:

1. Check File Placement
Ensure your file structure matches the package declaration exactly. Your files should be organized like this:


src/org/howard/edu/lsp/midterm/crccards/Task.java 
+1


src/org/howard/edu/lsp/midterm/crccards/TaskManager.java 
+1


src/org/howard/edu/lsp/midterm/crccards/Driver.java 

2. Compile All Files Together
The error "TaskManager cannot be resolved" often happens because Driver.java was compiled alone, or TaskManager.java hasn't been compiled into the bin directory yet. 
+1

Try compiling all classes in the package at once from your src folder:

Bash
javac -d ../bin org/howard/edu/lsp/midterm/crccards/*.java
3. Verify the Driver's Package
Double-check the top of your Driver.java file. It must have this exact line:

Java
package org.howard.edu.lsp.midterm.crccards; // 
If that line is missing or different, Driver won't be able to find TaskManager automatically. 
+1

4. Running the Code
When you run the program, you must be at the root of your compiled classes (the bin directory or your project root) and use the fully qualified name:

Bash
java org.howard.edu.lsp.midterm.crccards.Driver
Quick Tip: Since you are using VS Code (based on your file paths), try clicking the "Clean Java Language Server Workspace" command if the error persists. Sometimes the IDE's internal build gets out of sync.

You said
kimie@April UCRT64 /c/Users/kimie/Large Scale Programming/src/org/howard/edu/lsp/midterm

$ javac -d ../bin org/howard/edu/lsp/midterm/crccards/*.java

bash: javac: command not found

Gemini said
It looks like the Java compiler (javac) isn't in your shell's PATH environment variable, even though your IDE is clearly using a JDK.
+1

Since you are using UCRT64 (MSYS2/Git Bash), it doesn't automatically see the Windows Environment Variables unless configured to do so. Here is the quickest way to fix this and get your midterm running:

1. Point Directly to the Compiler
Instead of just typing javac, use the full path to the JDK that your system is already using. Based on your previous error message, your JDK is located at C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot.

Try running this command (the quotes are necessary because of the spaces in "Program Files"):

Bash
"/c/Program Files/Microsoft/jdk-25.0.2.10-hotspot/bin/javac" -d ../../../../../../../bin *.java
2. Why the path looks long (../../...)
In your terminal, you are currently inside .../src/org/howard/edu/lsp/midterm. To reach the bin folder at the root of your project, you have to go "up" several levels:

midterm -> lsp

lsp -> edu

edu -> howard

howard -> org

org -> src

src -> Project Root (where bin usually lives)

3. Move to the Project Root (Recommended)
It is much easier to compile from the root of your project (the Large Scale Programming folder).

Navigate to root: cd "/c/Users/kimie/Large Scale Programming"

Compile everything: ```bash
"/c/Program Files/Microsoft/jdk-25.0.2.10-hotspot/bin/javac" -d bin src/org/howard/edu/lsp/midterm/crccards/*.java

Run the Driver:

Bash
"/c/Program Files/Microsoft/jdk-25.0.2.10-hotspot/bin/java" -cp bin org.howard.edu.lsp.midterm.crccards.Driver
⚠️ A Note for your Development Log
Since you are encountering "Command Not Found" and pathing issues, make sure to note in your development_log.md that you used AI to troubleshoot shell environment configuration and manual compilation paths.
+1

Would you like the code for the Strategy Pattern (Question 3) next so you can keep moving? 
+1

You said
im using cmd now

Gemini said
Since you're using the standard Windows Command Prompt (CMD), the file paths use backslashes \ and we don't need the /c/ prefix used in Bash.

Because your Driver is throwing a java.lang.Error for "Unresolved compilation problems," it means the Driver.java file was compiled, but the compiler couldn't find TaskManager.java at that moment.
+1

Here is how to clean and rebuild your project directly in CMD:

1. Navigate to your Project Root
First, ensure you are at the base of your project folder:

DOS
cd "C:\Users\kimie\Large Scale Programming"
2. Compile Everything at Once
Running this command tells the compiler to look at all .java files in that folder together. This resolves the "cannot be resolved to a type" error because the compiler sees TaskManager and Task at the same time it processes Driver.
+1

DOS
"C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot\bin\javac.exe" -d bin src\org\howard\edu\lsp\midterm\crccards\*.java
3. Run the Program
Use the -cp bin flag to tell Java where your compiled .class files are, followed by the full package path of the Driver:
+2

DOS
"C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot\bin\java.exe" -cp bin org.howard.edu.lsp.midterm.crccards.Driver
Troubleshooting Tips
Check File Names: Ensure your files are named exactly Task.java and TaskManager.java. Java is case-sensitive.

Package Declaration: Open TaskManager.java and Task.java. Ensure the very first line is exactly: package org.howard.edu.lsp.midterm.crccards;.

Clean Build: If it still fails, manually delete everything inside your bin folder and run the javac command again to ensure no old, broken files are interfering.


Would you like to move on to the Strategy Pattern implementation for Question 3 now? 

You said
what should my midterm folder look like to have everything

Gemini said
To ensure you receive full credit and that your code compiles correctly, your project structure must strictly follow the package names provided in the exam.
+4

Here is the complete directory tree for your "Large Scale Programming" project folder:

📂 Project Root: Large Scale Programming
📂 bin/ (This is where your .class files will go after compilation)

📂 src/ (This is where all your .java and .md files must live)

📂 org/howard/edu/lsp/midterm/


📂 crccards/ (Question 1) 
+3


Driver.java 
+3


Task.java 
+1


TaskManager.java 
+1


📂 doc/ 


crccards.md 
+4


development_log.md 
+4


📂 design/doc/ (Question 2) 
+4


evaluation.md 
+4


design.md 
+4


development_log_q2.md 
+4


📂 strategy/ (Question 3) 
+4


DiscountStrategy.java (Interface) 


RegularDiscount.java 
+1


MemberDiscount.java 
+1


VIPDiscount.java 
+1


HolidayDiscount.java 
+1


PriceCalculator.java (Refactored) 
+1


Driver.java (Strategy Driver) 


📂 doc/ 
+1


design_evaluation.md 
+4


development_log_q3.md 
+4

⚠️ Critical Reminders for Submission

Package Declarations: Every .java file must have the package statement at the very top matching its folder path (e.g., package org.howard.edu.lsp.midterm.strategy;).
+3


Separate Files: Each Java class must be in its own .java file.
+1


Markdown Files: Ensure you have all five required .md files distributed across the three doc folders as shown above.
+4

GitHub: Push this entire structure to your repository. Only code in the repo at the end of the exam will be graded.
+1

Would you like to move on to the Strategy Pattern code for Question 3 now?