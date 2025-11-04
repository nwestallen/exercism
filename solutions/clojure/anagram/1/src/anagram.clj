(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word prospect-list]
  (let [wordletters (str/lower-case word)]
    (filter
     #(let [testletters (str/lower-case %)]
       (and
       (not= wordletters testletters)
       (= (frequencies wordletters) (frequencies testletters))))
     prospect-list)))
