(ns proverb
  (:require [clojure.string :as str]))

(defn recite [words]
  (if (= (count words) 0) ""
      (str/join "\n" (conj (mapv (partial apply #(str "For want of a " %1 " the " %2 " was lost.")) (partition 2 1 words)) (str "And all for the want of a " (first words) ".")))
      )
  )

