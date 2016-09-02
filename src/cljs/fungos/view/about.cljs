 (ns fungos.view.about
    (:require [re-frame.core :as re-frame]
              [fungos.view.icons :as icons]
              [fungos.view.sidebar :as sidebar]))


(defn main []
    (fn []
      [:div
       [:p "This application searches across InterMine instances for specific common template results."]
       [:a "Rat, mouse, fly, zebrafish, human, worm icons made by Freepik from www.flaticon.com" {:href "http://www.flaticon.com"}]
       ]))
