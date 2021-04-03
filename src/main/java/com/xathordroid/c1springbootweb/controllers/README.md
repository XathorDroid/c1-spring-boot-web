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

## Load Data to Views
When we indicate the view to load after request a path, we can specify, initialize or load the fields that will contain the info that will be show in the view.

We can do it adding to the constructor of the function invoked a param with type Model, ModelMap, Map or ModelAndView.

For it, we need to declare to a namespace in the view to use Thymeleaf properties in the `<html>` tag. 
Using the Thymeleaf properties with the namespace value, use the `$` sign and indicate the property between `{ }` to refer to the property to load. 
```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>Hello World</title>
</head>
<body>
<h1 th:text="${title}"></h1>
</body>
</html>
```

### Model
```
@GetMapping(value ="/index")
public String index(Model model) {
    model.addAttribute("title", "Hello Spring Framework!");
    return "index";
}
```

### ModelMap
```
@GetMapping(value = "/index")
public String indexModelMap(ModelMap model) {
    model.addAttribute("title", "Hello Spring Framework!");
    return "index";
}
```

### Map
```    
@GetMapping(value = "/index")
public String indexMap(Map<String, Object> map) {
    map.put("title", "Hello Spring Framework!");
    return "index";
}
```

### ModelAndView
``` 
@GetMapping(value = "/index")
public ModelAndView indexModelAndView(ModelAndView mv) {
    mv.addObject("title", "Hello Spring Framework!");
    mv.setViewName("index");
    return mv;
}
```

### With Annotation
We can also load data in a model attribute using an annotation in a specific function. Do it will do available that attribute to all views loaded in that controller.
```
@ModelAttribute("users")
public List<User> createUsersList() {
    List<User> users = new ArrayList<>();
    
    users.add(new User("Roberto", "Dos Santos", "user-one@email.com"));
    users.add(new User("Alfonso", "Jiménez", "user-two@email.com"));
    users.add(new User("Felipe", "Dos Santos", "user-three@email.com"));
    
    return users;
}
```
