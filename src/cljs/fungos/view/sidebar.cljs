 (ns fungos.view.sidebar
    (:require [re-frame.core :as re-frame]))

(defn organism-dropdown []
  "returns a dropdown containing all of the organism names"
  (let [organisms (re-frame/subscribe [:organisms])]
    [:label.input-organism
      [:p "For organism"]
      [:select {:on-change (fn [e] (re-frame/dispatch [:select-input-organism (aget e "target" "value")]))}
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
    [:label.gene-input [:p "Type a Gene name"]
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
          [:div.status
            [:svg.icon {:class id} [:use {:xlinkHref (str "#icon-" (clj->js id))}]]
            [:div.organism
             (:common details) " - " (:abbrev details)]]
      ) @organisms))
   ]
  )


(defn main []
  (fn []
    [:aside [:h2 "Search"]
      [:div.organism-selector "Searching 7 organisms"]
      [searchbox]
      [statusbox]
     [:footer [:a.foot {:href "#/about"} "About this tool"]]
]))
