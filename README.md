common
======

Java code to define JSON objects shared by all layers.
Primary usage is to define an object to be filled in the front end,
then create JSON text from that object to place in an HTTP request.
The back end parses the JSON back into the object, then processes
the request using that object.  Used in a similar manner to pass
information from the back end to the front end.
