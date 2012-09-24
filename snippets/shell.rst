count lines of code for a given language
----------------------------------------

::

        find -name "*.js" -print0 | wc -l --files0-from -

replace expression in code
--------------------------

::

        needle=extractProcessorId;replacement=extractId;sedexpr=$(echo "s/$needle/$replacement/g"); for i in $(ack-grep -l $needle); do sed -i $sedexpr $i; done
