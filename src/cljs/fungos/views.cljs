(ns fungos.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div.approot
       [:aside [:h1 "Cross organism InterMine template search"]]
       [:main "Search for genez." ]
       "Hello from " @name
       ])))
