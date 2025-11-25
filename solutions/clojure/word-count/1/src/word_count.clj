(ns word-count (:require [clojure.string :as str]))

(defn word-count
  "Counts how many times each word occurs in the given string."
  [s]
  (->> s
       (str/lower-case)
       (re-seq #"\w+'\w+|\b\w+")
       (frequencies))
  )

