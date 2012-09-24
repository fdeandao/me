notmuch tips
============

remove mailing list emails
--------------------------

::
        notmuch search --output=files to:pypy-dev@python.org | xargs -l rm
        notmuch search --output=files to:pyar@python.org.ar | xargs -l rm
        notmuch new
