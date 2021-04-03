# Controllers
## Mapping Annotations
We can create a request mapping using the generic annotation `RequestMapping`
```
@RequestMapping(value = "/index", method = RequestMethod.GET)
```
- `value` = the path that will invoke the function annotated
- `method` = method type for the request (GET, POST, PUT, DELETE...)
---
We can also use a more specific annotation for each request method where we wont add the method param
```
@GetMapping(value ="/index")
```
---
If it's necessary, we could indicate as value for the `value` param multiple paths that will be attended by the function annotated
```
@GetMapping({ "/index", "/", "/home" })
```
