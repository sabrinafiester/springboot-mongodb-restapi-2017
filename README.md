Requires:
- Java 1.8
- Gradle
- Mongodb

Run/test:

1. Start mongodb with `mongod` in terminal
2. In separate terminal (or using ID build functionality) run `gradle build` folllowed by `gradle bootRun`
3. Run `gradle clean test` to run tests

POST Example:


`curl -i -X POST -H "Content-Type: application/json" -d '{"tcin":52205298,"price":29.99,"offerPrice":14.98,"offerStart":1516521600000, "offerEnd":253402236000000}' localhost:8080/prices`

response - 52205298


GET Example: 

```curl -i -H "Accept: application/json" localhost:8080/products/11548345```

response-
```{"product":{"item":{"tcin":"11548345","product_description":{"title":"Harry Potter and the Half-blood Prince ( Harry Potter) (Reprint) (Paperback) by J. K. Rowling"},"price":{"tcin":"11548345","price":12.99,"offerPrice":9.29,"offerStart":1520582400000,"offerEnd":253402236000000}}}}```
