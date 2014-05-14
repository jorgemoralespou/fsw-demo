# SwitchYard Bindy integration - Marshal and unmarshal
This project tests unmarshaling from Bean to CSV file

## Prerequitites

Install bindy module (for that only dependency is on **camel-bindy-2.10.0.redhat-60024.jar**

## How to test

Just deploy and activate the service. A cron schedule ( * 1/5 * * * ? ) will trigger execution, and a file will be written in /tmp/marshal3


Output: You will get a file in /tmp named marshal3 with following content:
````
Order ID,Batch ID,Customer Number,Customer,IMSI,MSISDN,SIM Spec Ref,Quantity,Required Date,Delivery Address,Shipment Type,Package Marking,Reference Contact,Contact Telephone Number,Email
1,2,3,Name,1111,2222,SimId,25,2014/05/14 08:48:17,Address,ShipmentType,packageMarking,contactName,contactPhoneNumber,contactEmail
Order ID,Batch ID,Customer Number,Customer,IMSI,MSISDN,SIM Spec Ref,Quantity,Required Date,Delivery Address,Shipment Type,Package Marking,Reference Contact,Contact Telephone Number,Email
1,2,3,Name,1111,2222,SimId,25,2014/05/14 08:48:17,Address,ShipmentType,packageMarking,contactName,contactPhoneNumber,contactEmail
Order ID,Batch ID,Customer Number,Customer,IMSI,MSISDN,SIM Spec Ref,Quantity,Required Date,Delivery Address,Shipment Type,Package Marking,Reference Contact,Contact Telephone Number,Email
1,2,3,Name,1111,2222,SimId,25,2014/05/14 08:48:18,Address,ShipmentType,packageMarking,contactName,contactPhoneNumber,contactEmail
Order ID,Batch ID,Customer Number,Customer,IMSI,MSISDN,SIM Spec Ref,Quantity,Required Date,Delivery Address,Shipment Type,Package Marking,Reference Contact,Contact Telephone Number,Email
1,2,3,Name,1111,2222,SimId,25,2014/05/14 08:48:19,Address,ShipmentType,packageMarking,contactName,contactPhoneNumber,contactEmail
Order ID,Batch ID,Customer Number,Customer,IMSI,MSISDN,SIM Spec Ref,Quantity,Required Date,Delivery Address,Shipment Type,Package Marking,Reference Contact,Contact Telephone Number,Email
1,2,3,Name,1111,2222,SimId,25,2014/05/14 08:48:20,Address,ShipmentType,packageMarking,contactName,contactPhoneNumber,contactEmail
````

## NOTES:
Headers will be printed for every bean inserted. (This is a bug in design, but not a problem for bindy marshaling demonstration)
