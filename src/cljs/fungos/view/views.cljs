 (ns fungos.view.views
    (:require [re-frame.core :as re-frame]
              [fungos.view.icons :as icons]
              [fungos.view.sidebar :as sidebar]))


(defn main-panel []
    (fn []
      [:div.approot
        [icons/icons]
        [sidebar/main]
       [:main [:h1 "Cross organism InterMine template search"]
        "Search for genez. Hello from meeee" [:svg.icon [:use {:xlinkHref "#icon-rat"}]]]
       ]))
