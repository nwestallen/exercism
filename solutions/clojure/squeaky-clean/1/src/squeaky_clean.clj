(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean
  "cleans up identifier names"
  [s]
  (as-> s t
    (if (str/includes? t "-")
      (as-> t v (str/split v #"-")
            (concat (first v)
                    (map #(str/join (concat (str/upper-case (first %)) (rest %))) (rest v)))
            (str/join v)) t)
    (map #(if (Character/isISOControl %) "CTRL" %) t)
    (str/join t)
    (filter #(or (Character/isLetter %) (Character/isWhitespace %)) t)
    (str/join t)
    (str/replace t #"[\u03B1-\u03C9]" "")
    (str/replace t " " "_")))


