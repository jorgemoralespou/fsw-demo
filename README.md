# fsw-demo #
These are a set of apps for FSW PoC intentions

## fsw-sample-service ##
This application demostrates orchestration combining different SY components, bindings,... 

### CSV ###
To validate CSV parsing functionality, drop a CSV file (captation.csv) into /tmp directory.
It will print out in console the contents of the CSV file in a more human readable format.

```
Jorge Morales,00123FA21,FFAA1212,1,100
Jorge Morales,00123FA21,FFAA1212,2,125
Jorge Morales,00123FA21,FFAA1212,3,131
Jorge Morales,00123FA21,FFAA1212,4,207
Jorge Morales,00123FA21,FFAA1212,5,303
Jorge Morales,00123FA21,FFAA1212,6,331
Jorge Morales,00123FA21,FFAA1212,7,352
Jorge Morales,00123FA21,FFAA1212,8,423
Jorge Morales,00123FA21,FFAA1212,9,423
Jorge Morales,00123FA21,FFAA1212,10,427
Jorge Morales,00123FA21,FFAA1212,11,434
Jorge Morales,00123FA21,FFAA1212,12,461
```

You'll se somthing similar to this:
```
12:00:16,053 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 2: 125
12:00:16,077 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 3: 131
12:00:16,099 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 4: 207
12:00:16,123 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 5: 303
12:00:16,146 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 6: 331
12:00:16,169 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 7: 352
12:00:16,193 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 8: 423
12:00:16,218 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 9: 423
12:00:16,241 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 10: 427
12:00:16,266 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 11: 434
12:00:16,288 INFO  [route2] (Camel (camel-8) thread #7 - file:///tmp) Metering for Jorge Morales[EAN=FFAA1212, METER=00123FA21] for 12: 461
```

### JPA ###
To validate JPA functionality, drop a CSV file (captation.csv) into /tmp directory.
It will insert a record for every CSV registry in DB.

To validate it, open an h2console deployed in the JBossAS (or EAP) and connect to:

__jdbc:h2:mem:test;DB_CLOSE_DELAY=-1__

With __sa/sa__


