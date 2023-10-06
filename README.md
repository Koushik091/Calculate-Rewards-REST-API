Coding Challenge: 

Problem:

A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows:
 
For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total. 
1. Make up a data set to best demonstrate your solution
2. Check solution into GitHub and please share the GitHub URL.

Write a REST API that calculates and returns the reward points in Java using Spring Boot as a microservice. 


We used H2 database in our application which is provided by spring boot. Below are the sample data we created using below sql script. Script is run when we launch our application. App is deployed on embedded tomcat server which spring boot offers.

![A screen shot of a computer

Description automatically generated](Aspose.Words.512e751e-2834-4ef9-9f7a-46a49a7fe138.001.png)

Customer data 

![A screenshot of a computer

Description automatically generated](Aspose.Words.512e751e-2834-4ef9-9f7a-46a49a7fe138.002.png)

Transaction data

![A screenshot of a computer

Description automatically generated](Aspose.Words.512e751e-2834-4ef9-9f7a-46a49a7fe138.003.png)

REST Endpoints in the application

1. Get all customer data with respective transaction data and reward points <http://localhost:8080/api/customers>

Sample response:

[

`    `{

`        `"id": 1,

`        `"name": "Koushik",

`        `"transactions": [

`            `{

`                `"points": 0,

`                `"id": 2,

`                `"total": 50.0,

`                `"description": "Purchase 2",

`                `"saveDate": "2020-10-24T15:20:10.000+0000"

`            `},

`            `{

`                `"points": 90,

`                `"id": 3,

`                `"total": 120.0,

`                `"description": "Purchase 3",

`                `"saveDate": "2020-10-24T15:20:10.000+0000"

`            `},

`            `{

`                `"points": 0,

`                `"id": 8,

`                `"total": 25.6,

`                `"description": "Purchase 200",

`                `"saveDate": "2020-10-17T17:20:10.000+0000"

`            `},

`            `{

`                `"points": 50,

`                `"id": 1,

`                `"total": 100.0,

`                `"description": "Purchase 1",

`                `"saveDate": "2020-10-25T15:20:10.000+0000"

`            `},

`            `{

`                `"points": 250,

`                `"id": 11,

`                `"total": 200.0,

`                `"description": "Purchase 5",

`                `"saveDate": "2020-10-24T15:20:10.000+0000"

`            `}

`        `],

`        `"rewardPoints": 390,

`        `"totalPurchases": 495.6

`    `},

`    `{

`        `"id": 2,

`        `"name": "Venkatesh",

`        `"transactions": [

`            `{

`                `"points": 30,

`                `"id": 9,

`                `"total": 80.5,

`                `"description": "Purchase 201",

`                `"saveDate": "2020-10-19T20:00:10.000+0000"

`            `},

`            `{

`                `"points": 15,

`                `"id": 5,

`                `"total": 65.75,

`                `"description": "Purchase 20",

`                `"saveDate": "2020-10-26T15:20:10.000+0000"

`            `},

`            `{

`                `"points": 200,

`                `"id": 4,

`                `"total": 175.32,

`                `"description": "Purchase 10",

`                `"saveDate": "2020-10-26T15:20:10.000+0000"

`            `}

`        `],

`        `"rewardPoints": 245,

`        `"totalPurchases": 321.57

`    `},

`    `{

`        `"id": 3,

`        `"name": "Satwik",

`        `"transactions": [

`            `{

`                `"points": 270,

`                `"id": 6,

`                `"total": 210.5,

`                `"description": "Purchase 30",

`                `"saveDate": "2020-10-26T15:20:10.000+0000"

`            `},

`            `{

`                `"points": 0,

`                `"id": 7,

`                `"total": 42.8,

`                `"description": "Purchase 31",

`                `"saveDate": "2020-10-25T22:10:10.000+0000"

`            `},

`            `{

`                `"points": 82,

`                `"id": 10,

`                `"total": 116.14,

`                `"description": "Purchase 202",

`                `"saveDate": "2020-10-22T16:30:10.000+0000"

`            `}

`        `],

`        `"rewardPoints": 352,

`        `"totalPurchases": 369.44

`    `}

]


1. Get transaction data and reward points for that specific customer [http://localhost:8080/api/customers/{id}](http://localhost:8080/api/customers/%7bid%7d)

Sample response:

{

`    `"id": 1,

`    `"name": "Koushik",

`    `"transactions": [

`        `{

`            `"points": 0,

`            `"id": 2,

`            `"total": 50.0,

`            `"description": "Purchase 2",

`            `"saveDate": "2020-10-24T15:20:10.000+0000"

`        `},

`        `{

`            `"points": 50,

`            `"id": 1,

`            `"total": 100.0,

`            `"description": "Purchase 1",

`            `"saveDate": "2020-10-25T15:20:10.000+0000"

`        `},

`        `{

`            `"points": 90,

`            `"id": 3,

`            `"total": 120.0,

`            `"description": "Purchase 3",

`            `"saveDate": "2020-10-24T15:20:10.000+0000"

`        `},

`        `{

`            `"points": 0,

`            `"id": 8,

`            `"total": 25.6,

`            `"description": "Purchase 200",

`            `"saveDate": "2020-10-17T17:20:10.000+0000"

`        `},

`        `{

`            `"points": 250,

`            `"id": 11,

`            `"total": 200.0,

`            `"description": "Purchase 5",

`            `"saveDate": "2020-10-24T15:20:10.000+0000"

`        `}

`    `],

`    `"rewardPoints": 390,

`    `"totalPurchases": 495.6

}

