(ns fungos.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [fungos.core-test]))

(doo-tests 'fungos.core-test)
