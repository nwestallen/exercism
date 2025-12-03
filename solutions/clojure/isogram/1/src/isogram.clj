(ns isogram
  (:require [clojure.string :as str]))

(defn isogram?
  "Returns true if the given string is an isogram;
  otherwise, it returns false."
  [s]
  (if (= s "") true
      (= (apply max (vals (dissoc (frequencies (str/lower-case s)) \space \-))) 1)
      )
  )

