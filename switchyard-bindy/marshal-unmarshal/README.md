# SwitchYard Bindy integration - Marshal and unmarshal
This project tests marshaling and unmarshaling of a CSV file to Bean and from Bean to CSV file

## Prerequitites

Install bindy module (for that only dependency is on **camel-bindy-2.10.0.redhat-60024.jar**

## How to test

Create a file in /tmp/csv with following contents:
````
1|Student 1|1st|80|56|54|90|90
2|Student 2|1st|70|65|75|90|11
3|Student 3|1st|60|56|54|90|93
4|Student 4|1st|50|65|75|90|53
5|Student 5|1st|40|56|54|90|77
6|Student 6|1st|30|65|75|90|34
7|Student 7|1st|40|56|54|90|74
8|Student 8|1st|50|65|75|90|68
9|Student 9|1st|60|56|54|90|44
````

Output: You will get a file in /tmp named marshal with following content:
````
1|Student 1|1st|A|370|Pass
2|Student 2|1st|B+|311|Pass
3|Student 3|1st|A|353|Pass
4|Student 4|1st|B+|333|Pass
5|Student 5|1st|B+|317|Pass
6|Student 6|1st|B|294|Pass
7|Student 7|1st|B+|314|Pass
8|Student 8|1st|B+|348|Pass
9|Student 9|1st|B+|304|Pass
````

## NOTES:
Classes for BindyCSVDataFormat must be in separate classes, as it seems there is a bug otherwise, where it says something like:
````
java.lang.IllegalArgumentException: Some mandatory fields are missing, line: 1: java.lang.IllegalArgumentException: Some mandatory fields are missing, line: 1
````
