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

Using Model:
```
@GetMapping(value ="/index")
public String index(Model model) {
    model.addAttribute("title", "Hello Spring Framework!");
    return "index";
}
```

Using ModelMap:
```
@GetMapping(value = "/index")
public String indexModelMap(ModelMap model) {
    model.addAttribute("title", "Hello Spring Framework!");
    return "index";
}
```

Using Map
```    
@GetMapping(value = "/index")
public String indexMap(Map<String, Object> map) {
    map.put("title", "Hello Spring Framework!");
    return "index";
}
```

Using ModelAndView
``` 
@GetMapping(value = "/index")
public ModelAndView indexModelAndView(ModelAndView mv) {
    mv.addObject("title", "Hello Spring Framework!");
    mv.setViewName("index");
    return mv;
}
```
