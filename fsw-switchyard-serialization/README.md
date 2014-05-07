Serialization project
=====================
These projects has 2 file bindings, reading from /tmp/name.txt (a one line String file) or from /tmp/sca.txt.

If /tmp/name.txt is written, ServiceA (caller) will call ServiceB (callee) via SCA provided capabilities, with SCA binding (Normal pojos as parameters).

If /tmp/sca.txt is written, ServiceA (caller) will call ServiceB (callee) via HttpInvoker without a binding (This time parameters are generics, with non no-arg constructor, and builder with builders). On the receiving side, null is deserialized.

These are stack traces from calling side and called side.
````
22:44:51,810 INFO  [stdout] (Camel (camel-9) thread #17 - file:///tmp) ---- CALLING with: Container{operation=myOp, target=100, Id=100}
22:44:51,835 INFO  [stdout] (http-/127.0.0.1:8080-1) --- SCA Reference called with: null
````


