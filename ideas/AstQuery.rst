Ast Query - Query and manipulate ASTs with a jquery-like DSL
============================================================

concepts
--------

CM
..

Code Mode

an abstract representation of the code

selectors
---------

.ClassName
#instance (or variable)
@attribute
\function (or method)
anyOfTheAbove (match anything that's names anyOfTheAbove)

^blockType (for example if/else, switch, try/catch)

:type(type1) (is of type1)
:type(type1, type2) (is of type1 or type2)
:is(class) :is(instance) :is(attribute) :is(function) :is(method)
:arg(<selector>) filter arguments from the previous selector (constructor args for classes, args for funs/methods)
:n


.ClassName > foo (something named foo at the first level under class named ClassName)
^if

actions
-------

* rename(newName)
* remove()
* append(cm): append CM to the current selected CM
* prepend(cm)
* insert(cm, index)
* toString(): print current CM representation
* find(<selector>): apply a selector to the current CM
