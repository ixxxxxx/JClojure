(ns jay.mars.market.seq
  (:require [clojure.java.jdbc :as jdbc])
  (:require [jaskell.sql :refer [select from as]])
  (:require [jay.mars.market.config :as config]])
  (:require [cheshire.core :refer [generate-string]]))

(def db-spec (delay (config/db-spec)))

(defn create-seq
  [^String seq-name]
  (-> @db-spec
      (jdbc/execute! (str "create sequence " seq-name))
      first))

(defn list-seq
  []
  (let [sql (-> (select ["sequencename" :as :name " COALESCE(last_value, start_value)" as "last"] from :pg_sequences)
                (.script))]
    (-> @db-spec
        (jdbc/query [sql])
        (into-array))))

(defn next-val
  [seq-name]
  (-> @db-spec
      (jdbc/execute! (str "drop sequence " seq-name))
      first))

(defn drop-seq
  [seq-name]
  (jdbc/execute! db-spec (str "drop sequence " seq-name)))