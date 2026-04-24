# AI Usage Documentation

**AI Tools Used:**
Gemini

**Prompts Used:**

1. "give a checklist with submission requirements and the file structure for this"
2. "briefly explain what is happening in the code"
3. "give me the code snippet for part 4"

**How AI Helped:**
The AI helped organize the exam's complex submission requirements into a clear directory structure and checklist. It also provided a technical analysis of the thread-safety issues in the provided Java code and suggested an alternative synchronization approach using AtomicInteger for Part 4.

**Reflection:**
Working through this helped me realize how easily race conditions can slip into standard code and why it's often cleaner to use built-in concurrent utilities instead of manual synchronization. It gave me a much better handle on how to manage shared resources in a multi-threaded environment.
