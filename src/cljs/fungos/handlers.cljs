(ns fungos.handlers
    (:require [re-frame.core :as re-frame]
              [fungos.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
