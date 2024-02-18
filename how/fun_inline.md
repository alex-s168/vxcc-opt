# Function Inlining

To inline any function, like the one on the left, we need to make sure that it doesn't use return anywhere.

The right function is modified to only have one single return (at the end of the function).
```
fun f(x) {                     . fun f(x) {
                               +   var cancel = false
                               +   var ret
  while (true) {               .   while (true) {
    x --                       .     x --
    var y = x                  .     var y = x
    while (y > 0) {            .     while (y > 0) {
      y --                     .       y --
      if (y == 22) {           .       if (y == 2) {
                               +         cancel = true
                               +         ret = 2
        return 2               *         break
      }                        .       }
    }                          .     }
                               +     if (cancel) {
                               +       break
                               +     }
    if (x == 11) {             .     if (x == 11) {
                               +       cancel = true
                               +       ret = 1
      return 1                 *       break
    }                          .     }
    unpure_fun()               .     unpure_fun()
  }                            .   }
                               +   if (!cancel) {
  unpure_fun()                 .     unpure_fun()
                               +     cancel = true
  return 0                     *     ret = 1
                               +   }
                               +   return ret
}                               }
```
