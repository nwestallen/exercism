(ns reverse-string
  (:require [clojure.string :as str]))

(defn reverse-string
  ([s]
   (reverse-string (str/join (rest s)) (str (first s))))
  ([s r]
   (if (str/blank? s) r (recur (str/join (rest s)) (str (first s) r))))
)
