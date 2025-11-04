(ns scrabble-score
  (:require [clojure.string :as str]))

(defn score-letter [l]
  (case (first (str/upper-case l))
    (\A \E \I \O \U \L \N \R \S \T) 1
    (\D \G) 2
    (\B \C \M \P) 3
    (\F \H \V \W \Y) 4
    \K 5
    (\J \X) 8
    (\Q \Z) 10)
)

(defn score-word [w]
  (apply + (map score-letter w))
)
