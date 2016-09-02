(ns fungos.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

  (re-frame/register-sub
  :organisms
  (fn [db]
   (reaction (:organisms @db))))
