(ns rotational-cipher
  (:require [clojure.string :as str]))

(def alpha "abcdefghijklmnopqrstuvwxyz")

(defn rotate [s r]
(apply str (map
            #(let [res (if
               (str/includes? alpha (str (Character/toLowerCase %)))
               (get alpha (mod (+ r (str/index-of alpha (Character/toLowerCase %))) 26))
               %)]
               (if (Character/isUpperCase %)
                 (Character/toUpperCase res)
                 res)) s))
)
