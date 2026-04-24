Part 1:
Shared Resource #1: The `nextId` counter.
Shared Resource #2: The `requests` list.

Concurrency Problem: Race conditions. Since multiple requests are coming in at the exact same time, threads can trip over each other. This means two students might accidentally get the exact same request ID, or their requests might overwrite each other in the list.

Why addRequest() is unsafe: It takes multiple steps to get an ID and add the request to the list. If two threads jump into this method at the same time, they will mess up the counting and the list addition, which can lose data or crash the program.

Part 2:
Fix A: Explanation
Incorrect. Locking `getNextId()` stops duplicate IDs, but threads can still crash into each other when they try to add the actual request string to the `ArrayList`. The list itself still isn't protected.

Fix B: Explanation
Correct. Making the whole `addRequest()` method synchronized locks the entire process down. Only one thread can be in this method at a time, meaning getting the ID and adding to the list happen safely together without any interruptions.

Fix C: Explanation
Incorrect. This only protects the code when someone is reading the list. It does nothing to stop multiple threads from barging into `addRequest()` and corrupting the data while writing to it.

Part 3:
Answer + Explanation
No, it shouldn't be public. Arthur Riel's heuristics say you should keep a class's public footprint as small as possible. `getNextId()` is just an internal helper method. If you make it public, outside code could just spam the counter and increase the IDs for no reason, which breaks the system's internal logic.

Part 4:
Description:
Instead of using the `synchronized` keyword, you can use explicit locks like `ReentrantLock`. It works exactly like a physical lock and key. You lock the code right before you change the data, and then you unlock it inside a `finally` block when you're finished. This ensures only one thread does the work at a time.

Code Snippet:
private final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}
