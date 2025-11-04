(ns bob
  (:require [clojure.string :as str]))

(defn response-for [s]
  (let [t (str/trim s)]
    (cond
      (str/blank? t)
      "Fine. Be that way!"
      (and (re-matches #".*[a-zA-Z].*" t) (= t (str/upper-case t)))
      (if (= (last t) \?) "Calm down, I know what I'm doing!" "Whoa, chill out!")
      (= (last t) \?)
      "Sure."
      :else
      "Whatever.")))
