(ns fungos.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

  (re-frame/reg-sub-raw
  :organisms
  (fn [db]
   (reaction (:organisms @db))))
