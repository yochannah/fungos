 (ns fungos.views
    (:require [re-frame.core :as re-frame]))

    (defn organism-dropdown []
      "returns a dropdown containing all of the organism names"
      (let [organisms (re-frame/subscribe [:organisms])]
        [:label "Organism"  [:select {:on-change (fn [e] (re-frame/dispatch [:select-input-organism (aget e "target" "value")]))}
         (map (fn [[id details]]
            ^{:key id}
            [:option {:value (js->clj id)}
             (:common details) " - " (:abbrev details)])
          @organisms)
       ]]))

(defn searchbox
  "visual ui component for the search."
  []
  [:div.searchbox
    [:label "Type a Gene name"
      [:textarea {:placeholder "e.g. 'GATA1'..."}]]
    [organism-dropdown]
    [:button "Search"]]
  )

(defn statusbox
  "visual ui component to dispay loading statuses."
  []
  [:div.statusbox
   [:h3 "Status"]
   (let [organisms (re-frame/subscribe [:organisms])]

      (map (fn [[id details]]
         ^{:key id}
         [:div.status [:div.organism {:class id} (:common details) " - " (:abbrev details)]]
      ) @organisms))
   ]
  )


(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div.approot
        [:aside [:h2 "Search"]
          [:div.organism-selector "Searching 7 organisms"]
          [searchbox]
          [statusbox]
        ]
       [:main [:h1 "Cross organism InterMine template search"]
        "Search for genez. Hello from " @name]
       ])))
